#include "Graphics/Circle.h"
#include "Graphics/FrameBuffer.h"
#include "Graphics/Color.h"


namespace Graphics{

    void Circle::drawMidpoint(
        FrameBuffer& fb,
        int centerX,
        int centerY,
        int radius,
        Uint32 color
    )
    {
        int x = radius;
        int y = 0;
        int p = 1 - radius;

       

        while (x > y)
        {
            y++;

            if (p <= 0)
            {
                p = p + 2 * y + 1;
            }
            else
            {
                x--;
                p = p + 2 * y - 2 * x + 1;
            }

            if (x < y)
                break;

            fb.putPixel(centerX + x, centerY + y, color);
            fb.putPixel(centerX - x, centerY + y, color);
            fb.putPixel(centerX + x, centerY - y, color);
            fb.putPixel(centerX - x, centerY - y, color);

            if (x != y)
            {
                fb.putPixel(centerX + y, centerY + x, color);
                fb.putPixel(centerX - y, centerY + x, color);
                fb.putPixel(centerX + y, centerY - x, color);
                fb.putPixel(centerX - y, centerY - x, color);
            }

           
        }
    }

    void Circle::drawBresenham(
        FrameBuffer& fb,
        int centerX,
        int centerY,
        int radius,
        Uint32 color
    )
    {
        int x = radius;
        int y = 0;
        int p = 3 - 2 * radius;

        while (x >= y)
        {
            fb.putPixel(centerX + x, centerY + y, color);
            fb.putPixel(centerX - x, centerY + y, color);
            fb.putPixel(centerX + x, centerY - y, color);
            fb.putPixel(centerX - x, centerY - y, color);
            fb.putPixel(centerX + y, centerY + x, color);
            fb.putPixel(centerX - y, centerY + x, color);
            fb.putPixel(centerX + y, centerY - x, color);
            fb.putPixel(centerX - y, centerY - x, color);

            y++;

            if (p > 0)
            {
                x--;
                p = p + 4 * (y - x) + 10;
            }
            else
            {
                p = p + 4 * y + 6;
            }
        }
    }

}