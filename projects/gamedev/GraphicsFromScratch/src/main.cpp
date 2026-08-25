#define SDL_MAIN_HANDLED
#include "SDL2/SDL.h"
#include "Graphics/FrameBuffer.h"
#include <iostream>
#include "Graphics/Color.h"
#include "Graphics/Line.h"
#include "Graphics/Circle.h"
#include "Graphics/Fill.h"
#include "Graphics/Point.h"

#include <stack>
#include <vector>
#include <cmath>

// Tiny 5x7 font (A-Z, space, colon)
static const uint8_t FONT5x7[][5] = {
    {0x7C,0x12,0x11,0x12,0x7C}, // A
    {0x7F,0x49,0x49,0x49,0x36}, // B
    {0x3E,0x41,0x41,0x41,0x22}, // C
    {0x7F,0x41,0x41,0x22,0x1C}, // D
    {0x7F,0x49,0x49,0x49,0x41}, // E
    {0x7F,0x09,0x09,0x09,0x01}, // F
    {0x3E,0x41,0x49,0x49,0x7A}, // G
    {0x7F,0x08,0x08,0x08,0x7F}, // H
    {0x00,0x41,0x7F,0x41,0x00}, // I
    {0x20,0x40,0x41,0x3F,0x01}, // J
    {0x7F,0x08,0x14,0x22,0x41}, // K
    {0x7F,0x40,0x40,0x40,0x40}, // L
    {0x7F,0x02,0x0C,0x02,0x7F}, // M
    {0x7F,0x04,0x08,0x10,0x7F}, // N
    {0x3E,0x41,0x41,0x41,0x3E}, // O
    {0x7F,0x09,0x09,0x09,0x06}, // P
    {0x3E,0x41,0x51,0x21,0x5E}, // Q
    {0x7F,0x09,0x19,0x29,0x46}, // R
    {0x46,0x49,0x49,0x49,0x31}, // S
    {0x01,0x01,0x7F,0x01,0x01}, // T
    {0x3F,0x40,0x40,0x40,0x3F}, // U
    {0x1F,0x20,0x40,0x20,0x1F}, // V
    {0x7F,0x20,0x18,0x20,0x7F}, // W
    {0x63,0x14,0x08,0x14,0x63}, // X
    {0x03,0x04,0x78,0x04,0x03}, // Y
    {0x61,0x51,0x49,0x45,0x43}, // Z
    {0x00,0x00,0x00,0x00,0x00}, // space
    {0x00,0x00,0x14,0x00,0x00}  // colon (approx)
};

static void drawChar(Graphics::FrameBuffer &fb, int x, int y, char ch, Uint32 color)
{
    if (ch == ' ') { return; }
    int idx = 26; // space
    if (ch == ':') idx = 27;
    else if (ch >= 'A' && ch <= 'Z') idx = ch - 'A';
    else if (ch >= 'a' && ch <= 'z') idx = ch - 'a';

    for (int cx = 0; cx < 5; ++cx)
    {
        uint8_t col = FONT5x7[idx][cx];
        for (int cy = 0; cy < 7; ++cy)
        {
            if (col & (1 << cy))
                fb.putPixel(x + cx, y + cy, color);
        }
    }
}

static void drawText(Graphics::FrameBuffer &fb, int x, int y, const std::string &s, Uint32 color)
{
    int ox = x;
    for (char c : s)
    {
        drawChar(fb, ox, y, c, color);
        ox += 6; // 5 + 1 spacing
    }
}

int main()
{

    int WIDTH = 800;
    int HEIGHT = 600;

    if (SDL_Init(SDL_INIT_VIDEO) != 0)
    {
        std::cout << "SDL Init Failed\n";
        return 1;
    }

    SDL_Window *window = SDL_CreateWindow(
        "GraphicsFromScratch",
        SDL_WINDOWPOS_CENTERED,
        SDL_WINDOWPOS_CENTERED,
        WIDTH,
        HEIGHT,
        SDL_WINDOW_SHOWN);

    if (!window)
    {
        std::cout << "Window Creation Failed\n";
        return 1;
    }

    SDL_Renderer *renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);
    if (!renderer)
    {
        std::cout << "Renderer Creation Failed\n";
        return 1;
    }

    Graphics::FrameBuffer fb(renderer, WIDTH, HEIGHT);

    bool running = true;
    enum Mode { MODE_CIRCLE, MODE_LINE, MODE_POINT } currentMode = MODE_POINT;
    bool menuOpen = false;
    Uint32 currentColor = Graphics::WHITE;

    struct Shape {
        Mode type;
        Graphics::Point a;
        Graphics::Point b;
        int radius;
        Uint32 color;
    };

    std::vector<Shape> shapes;
    bool awaitingSecond = false; // for line/circle
    Graphics::Point tempPoint{0,0};

    while (running)
    {
        SDL_Event event;
        while (SDL_PollEvent(&event))
        {
            if (event.type == SDL_QUIT)
                running = false;

            if (event.type == SDL_MOUSEBUTTONDOWN && event.button.button == SDL_BUTTON_LEFT)
            {
                int mx = event.button.x;
                int my = event.button.y;

                // Title and menu button positions (menu placed after title)
                const std::string title = "GraphicsFromScratch";
                int titleX = 10; int titleY = 6;
                int menuBtnX = titleX + (int)title.size() * 6 + 8;
                SDL_Rect menuBtn{menuBtnX, 6, 40, 24};
                if (mx >= menuBtn.x && mx <= menuBtn.x + menuBtn.w && my >= menuBtn.y && my <= menuBtn.y + menuBtn.h)
                {
                    menuOpen = !menuOpen;
                    continue;
                }

                // If menu open, check items
                if (menuOpen)
                {
                    int itemW = 160;
                    int itemH = 20;
                    int startX = menuBtn.x;
                    int startY = menuBtn.y + menuBtn.h + 6;

                    // option rects
                    SDL_Rect r1{startX+6, startY + 18, itemW-12, itemH}; // Circle
                    SDL_Rect r2{startX+6, startY + 18 + itemH, itemW-12, itemH}; // Line
                    SDL_Rect r3{startX+6, startY + 18 + itemH*2, itemW-12, itemH}; // Point

                    if (mx >= r1.x && mx <= r1.x + r1.w && my >= r1.y && my <= r1.y + r1.h)
                    {
                        currentMode = MODE_CIRCLE;
                        menuOpen = false;
                        awaitingSecond = false;
                        continue;
                    }
                    if (mx >= r2.x && mx <= r2.x + r2.w && my >= r2.y && my <= r2.y + r2.h)
                    {
                        currentMode = MODE_LINE;
                        menuOpen = false;
                        awaitingSecond = false;
                        continue;
                    }
                    if (mx >= r3.x && mx <= r3.x + r3.w && my >= r3.y && my <= r3.y + r3.h)
                    {
                        currentMode = MODE_POINT;
                        menuOpen = false;
                        awaitingSecond = false;
                        continue;
                    }

                    // color picker boxes
                    int colorBoxSize = 14;
                    int colorsX = startX + 8;
                    int colorsY = startY + 18 + itemH*3 + 8;
                    std::vector<Uint32> palette = {Graphics::WHITE, Graphics::RED, Graphics::GREEN, Graphics::BLUE, Graphics::YELLOW};
                    for (size_t i = 0; i < palette.size(); ++i)
                    {
                        SDL_Rect cb{colorsX + (int)i*(colorBoxSize+6), colorsY, colorBoxSize, colorBoxSize};
                        if (mx >= cb.x && mx <= cb.x + cb.w && my >= cb.y && my <= cb.y + cb.h)
                        {
                            currentColor = palette[i];
                            menuOpen = false;
                            break;
                        }
                    }
                }

                // Canvas clicks -- add shapes depending on mode
                if (currentMode == MODE_POINT)
                {
                    Shape s; s.type = MODE_POINT; s.a = {mx, my}; s.color = currentColor; s.radius = 0; shapes.push_back(s);
                }
                else if (currentMode == MODE_LINE)
                {
                    if (!awaitingSecond)
                    {
                        tempPoint = {mx, my};
                        awaitingSecond = true;
                    }
                    else
                    {
                        Shape s; s.type = MODE_LINE; s.a = tempPoint; s.b = {mx, my}; s.color = currentColor; shapes.push_back(s);
                        awaitingSecond = false;
                    }
                }
                else if (currentMode == MODE_CIRCLE)
                {
                    if (!awaitingSecond)
                    {
                        tempPoint = {mx, my};
                        awaitingSecond = true;
                    }
                    else
                    {
                        int dx = mx - tempPoint.x;
                        int dy = my - tempPoint.y;
                        int r = (int)std::sqrt(dx*dx + dy*dy);
                        Shape s; s.type = MODE_CIRCLE; s.a = tempPoint; s.radius = r; s.color = currentColor; shapes.push_back(s);
                        awaitingSecond = false;
                    }
                }
            }
        }
        fb.clear(Graphics::BLACK);
        // fb.putPixel(100, 100, Graphics::RED);
        // Graphics::Line::DDA(fb, 50, 100, 500, 100, Graphics::GREEN);
        // Graphics::Line::Bresenham(fb, 50, 200, 500, 200, Graphics::BLUE);
        // Graphics::Circle::drawMidpoint(fb, 300, 400, 100, Graphics::RED);

        // render stored shapes
        for (auto &sh : shapes)
        {
            if (sh.type == MODE_POINT)
            {
                fb.putPixel(sh.a.x, sh.a.y, sh.color);
            }
            else if (sh.type == MODE_LINE)
            {
                Graphics::Line::Bresenham(fb, sh.a.x, sh.a.y, sh.b.x, sh.b.y, sh.color);
            }
            else if (sh.type == MODE_CIRCLE)
            {
                Graphics::Circle::drawBresenham(fb, sh.a.x, sh.a.y, sh.radius, sh.color);
            }
        }

        // draw title and menu button (menu placed after title)
        const std::string title = "GraphicsFromScratch";
        int titleX = 10; int titleY = 6;
        drawText(fb, titleX, titleY, title, Graphics::WHITE);
        int menuBtnX = titleX + (int)title.size() * 6 + 8;
        SDL_Rect menuBtn{menuBtnX, 6, 40, 24};
        Graphics::Line::Bresenham(fb, menuBtn.x, menuBtn.y, menuBtn.x + menuBtn.w, menuBtn.y, Graphics::WHITE);
        Graphics::Line::Bresenham(fb, menuBtn.x, menuBtn.y + menuBtn.h, menuBtn.x + menuBtn.w, menuBtn.y + menuBtn.h, Graphics::WHITE);
        Graphics::Line::Bresenham(fb, menuBtn.x, menuBtn.y, menuBtn.x, menuBtn.y + menuBtn.h, Graphics::WHITE);
        Graphics::Line::Bresenham(fb, menuBtn.x + menuBtn.w, menuBtn.y, menuBtn.x + menuBtn.w, menuBtn.y + menuBtn.h, Graphics::WHITE);
        // small hamburger lines (relative to menuBtn)
        Graphics::Line::Bresenham(fb, menuBtn.x + 6, menuBtn.y + 6, menuBtn.x + 30, menuBtn.y + 6, Graphics::WHITE);
        Graphics::Line::Bresenham(fb, menuBtn.x + 6, menuBtn.y + 12, menuBtn.x + 30, menuBtn.y + 12, Graphics::WHITE);

        // indicate current mode next to menu
        int modeIconX = menuBtn.x + menuBtn.w + 10;
        int modeIconY = 14;
        if (currentMode == MODE_CIRCLE) Graphics::Circle::drawBresenham(fb, modeIconX+8, modeIconY+8, 8, Graphics::BLUE);
        if (currentMode == MODE_LINE) Graphics::Line::Bresenham(fb, modeIconX, modeIconY+6, modeIconX+20, modeIconY+6, Graphics::RED);
        if (currentMode == MODE_POINT) fb.putPixel(modeIconX+10, modeIconY+10, Graphics::WHITE);

        // show current color box
        for (int cx = 0; cx < 10; ++cx) for (int cy = 0; cy < 10; ++cy) fb.putPixel(modeIconX+36+cx, modeIconY+2+cy, currentColor);
        drawText(fb, modeIconX+48, modeIconY-2, "Current:", Graphics::WHITE);
        std::string name = (currentMode==MODE_CIRCLE?"CIRCLE":(currentMode==MODE_LINE?"LINE":"POINT"));
        drawText(fb, modeIconX+48, modeIconY+8, name, Graphics::WHITE);

        // draw menu dropdown when open
        if (menuOpen)
        {
            int itemW = 160;
            int itemH = 20;
            int startX = menuBtn.x;
            int startY = menuBtn.y + menuBtn.h + 6;
            // fill background
            for (int yy = startY; yy < startY + 18 + itemH*3 + 40; ++yy)
                for (int xx = startX; xx < startX + itemW; ++xx)
                    fb.putPixel(xx, yy, Graphics::GRAY);

            // border
            Graphics::Line::Bresenham(fb, startX, startY, startX + itemW, startY, Graphics::WHITE);
            Graphics::Line::Bresenham(fb, startX, startY + 18 + itemH*3 + 36, startX + itemW, startY + 18 + itemH*3 + 36, Graphics::WHITE);
            Graphics::Line::Bresenham(fb, startX, startY, startX, startY + 18 + itemH*3 + 36, Graphics::WHITE);
            Graphics::Line::Bresenham(fb, startX + itemW, startY, startX + itemW, startY + 18 + itemH*3 + 36, Graphics::WHITE);

            // header
            drawText(fb, startX + 8, startY + 2, "SHAPES", Graphics::WHITE);

            // options text
            drawText(fb, startX + 18, startY + 18, "CIRCLE", Graphics::BLACK);
            drawText(fb, startX + 18, startY + 18 + itemH, "LINE", Graphics::BLACK);
            drawText(fb, startX + 18, startY + 18 + itemH*2, "POINT", Graphics::BLACK);

            // color picker
            int colorBoxSize = 14;
            int colorsX = startX + 8;
            int colorsY = startY + 18 + itemH*3 + 8;
            std::vector<Uint32> palette = {Graphics::WHITE, Graphics::RED, Graphics::GREEN, Graphics::BLUE, Graphics::YELLOW};
            for (size_t i = 0; i < palette.size(); ++i)
            {
                int bx = colorsX + (int)i*(colorBoxSize+6);
                for (int yy = 0; yy < colorBoxSize; ++yy)
                    for (int xx = 0; xx < colorBoxSize; ++xx)
                        fb.putPixel(bx + xx, colorsY + yy, palette[i]);
                // border
                Graphics::Line::Bresenham(fb, bx, colorsY, bx + colorBoxSize, colorsY, Graphics::WHITE);
                Graphics::Line::Bresenham(fb, bx, colorsY + colorBoxSize, bx + colorBoxSize, colorsY + colorBoxSize, Graphics::WHITE);
            }
        }
            
        // Graphics::floodFill(fb, 600, 400, Graphics::BLACK, Graphics::GREEN);
        // fb.present();

        // Draw rectangle using your Line class ( for 200*200 rectangle )
        // Graphics::Line::Bresenham(fb, 10, 10, 190, 10, Graphics::WHITE);
        // Graphics::Line::Bresenham(fb, 190, 10, 190, 190, Graphics::WHITE);
        // Graphics::Line::Bresenham(fb, 190, 190, 10, 190, Graphics::WHITE);
        // Graphics::Line::Bresenham(fb, 10, 190, 10, 10, Graphics::WHITE);

        // Fill inside
        // Graphics::Fill::boundaryFill(fb, 100, 100, Graphics::GREEN, Graphics::WHITE);

        fb.present();
    }

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return 0;
}