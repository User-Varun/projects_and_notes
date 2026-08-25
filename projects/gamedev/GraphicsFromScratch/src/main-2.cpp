#define SDL_MAIN_HANDLED
#include <SDL2/SDL.h>
#include <iostream>

/*
 1. Build A Framebuffer , using the SDL2 texture streaming method. The framebuffer will be a 1D array of pixels, where each pixel is represented by a 32-bit integer (ARGB format). The framebuffer will be initialized to black (0) and will be updated based on user input (mouse clicks).
*/



void draw8Points(SDL_Renderer* renderer, int cx, int cy, int x, int y)
{
    SDL_SetRenderDrawColor(renderer, 255, 255, 255, 255);

    // Original point
    SDL_RenderDrawPoint(renderer, cx + x, cy + y);

    // Mirror over Y-axis
    SDL_RenderDrawPoint(renderer, cx - x, cy + y);

    // Mirror over X-axis
    SDL_RenderDrawPoint(renderer, cx + x, cy - y);

    // Mirror over both axes
    SDL_RenderDrawPoint(renderer, cx - x, cy - y);

    // Swap x and y
    SDL_RenderDrawPoint(renderer, cx + y, cy + x);

    SDL_RenderDrawPoint(renderer, cx - y, cy + x);

    SDL_RenderDrawPoint(renderer, cx + y, cy - x);

    SDL_RenderDrawPoint(renderer, cx - y, cy - x);
}


int main()
{
    int WIDTH = 800;
    int HEIGHT = 600;
    Uint32 frameBuffer[WIDTH * HEIGHT];

    if (SDL_Init(SDL_INIT_VIDEO) != 0)
    {
        std::cout << "SDL Init Failed\n";
        return 1;
    }

    // initialize the framebuffer to black (0)
    for (int i = 0; i < WIDTH * HEIGHT; i++)
    {
        frameBuffer[i] = 0;
    }

    int x = 400;
    int y = 300;

    // Set the pixel at (x, y) to white (0xFFFFFFFF) in middle
    frameBuffer[y * WIDTH + x] = 0xFFFFFFFF;

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

    SDL_Texture *texture = SDL_CreateTexture(
        renderer,
        SDL_PIXELFORMAT_ARGB8888,
        SDL_TEXTUREACCESS_STREAMING,
        WIDTH,
        HEIGHT);

    if (!texture)
    {
        std::cout << "Texture Creation Failed\n";
        return 1;
    }

    bool running = true;

    while (running)
    {
        SDL_Event event;

        while (SDL_PollEvent(&event))
        {
            if (event.type == SDL_QUIT)
            {
                running = false;
            }

            if(event.type == SDL_MOUSEBUTTONDOWN)
            {
                int mouseX = event.button.x;
                int mouseY = event.button.y;

                // Set the pixel at (mouseX, mouseY) to white (0xFFFFFFFF)
                if(mouseX >= 0 && mouseX < WIDTH && mouseY >= 0 && mouseY < HEIGHT)
                {
                    frameBuffer[mouseY * WIDTH + mouseX] = 0xFFFFFFFF;
                }
            }
        }

        // Copy CPU framebuffer to GPU texture
        // SDL_UpdateTexture(
        //     texture,
        //     nullptr,
        //     frameBuffer,
        //     WIDTH * sizeof(Uint32));

        // // Clear screen
        // SDL_RenderClear(renderer);

        // // Draw texture
        // SDL_RenderCopy(renderer, texture, nullptr, nullptr);

        // // Present
        // SDL_RenderPresent(renderer);

        
        // Clear screen to black
    SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
    SDL_RenderClear(renderer);

    // Draw the 8 symmetric points
    draw8Points(renderer, 400, 300, 50, 100);

    SDL_RenderPresent(renderer);
    }

    SDL_DestroyWindow(window);
    SDL_DestroyTexture(texture);
    SDL_DestroyRenderer(renderer);
    SDL_Quit();

    return 0;
}
