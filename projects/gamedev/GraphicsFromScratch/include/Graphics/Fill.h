#pragma once

#include "Graphics/FrameBuffer.h"

namespace Graphics
{

class Fill
{
public:

    static void boundaryFill(
        FrameBuffer& fb,
        int x,
        int y,
        Uint32 fillColor,
        Uint32 boundaryColor
    );

    static void floodFill(
        FrameBuffer& fb,
        int x,
        int y,
        Uint32 oldColor,
        Uint32 newColor
    );

};

}