#pragma once

#include "Graphics/FrameBuffer.h"

namespace Graphics
{

class Circle
{
public:

    static void drawMidpoint(
        FrameBuffer& fb,
        int centerX,
        int centerY,
        int radius,
        Uint32 color
    );

    static void drawBresenham(
        FrameBuffer& fb,
        int centerX,
        int centerY,
        int radius,
        Uint32 color
    );

};

}