#include "Graphics/Line.h"
#include "Graphics/FrameBuffer.h"


namespace Graphics
{

    void Line::DDA(
        FrameBuffer& fb,
        int x1,
        int y1,
        int x2,
        int y2,
        Uint32 color)
    {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = std::max(abs(dx), abs(dy));

        float xIncrement = dx / static_cast<float>(steps);
        float yIncrement = dy / static_cast<float>(steps);

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++)
        {
            fb.putPixel(static_cast<int>(x), static_cast<int>(y), color);
            x += xIncrement;
            y += yIncrement;
        }
    }

    void Line::Bresenham(
        FrameBuffer& fb,
        int x1,
        int y1,
        int x2,
        int y2,
        Uint32 color)
    {
        int dx = abs(x2 - x1);
        int dy = abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;

        while (true)
        {
            fb.putPixel(x1, y1, color);

            if (x1 == x2 && y1 == y2)
                break;

            int err2 = 2 * err;
            if (err2 > -dy)
            {
                err -= dy;
                x1 += sx;
            }
            if (err2 < dx)
            {
                err += dx;
                y1 += sy;
            }
        }
    }

}