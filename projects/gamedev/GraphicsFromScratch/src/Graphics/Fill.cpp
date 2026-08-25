#include "Graphics/Fill.h"
#include "Graphics/Point.h"
#include <stack>

namespace Graphics
{

    void Fill::boundaryFill(
    FrameBuffer& fb,
    int x,
    int y,
    Uint32 fillColor,
    Uint32 boundaryColor)
{
    std::stack<Point> pixels;

    pixels.push({x, y});

    while (!pixels.empty())
    {
        Point current = pixels.top();
        pixels.pop();

        if (current.x < 0 || current.x >= fb.getWidth() ||
            current.y < 0 || current.y >= fb.getHeight())
        {
            continue;
        }

        Uint32 color = fb.getPixel(current.x, current.y);

        if (color == boundaryColor)
            continue;

        if (color == fillColor)
            continue;

        fb.putPixel(current.x, current.y, fillColor);

        pixels.push({current.x + 1, current.y});
        pixels.push({current.x - 1, current.y});
        pixels.push({current.x, current.y + 1});
        pixels.push({current.x, current.y - 1});
    }
}

}