#pragma once

#include "Graphics/FrameBuffer.h"

namespace Graphics
{

class Line
{
public:

    static void DDA(
        FrameBuffer& fb,
        int x1,
        int y1,
        int x2,
        int y2,
        Uint32 color
    );

    static void Bresenham(
        FrameBuffer& fb,
        int x1,
        int y1,
        int x2,
        int y2,
        Uint32 color
    );

};

}