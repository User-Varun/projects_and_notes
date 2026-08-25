#pragma once

#include <SDL2/SDL.h>

namespace Graphics
{

class FrameBuffer
{
public:

    FrameBuffer(
        SDL_Renderer* renderer,
        int width,
        int height
    );

    ~FrameBuffer();

    void clear(Uint32 color);

    void putPixel(
        int x,
        int y,
        Uint32 color
    );

    Uint32 getPixel(
        int x,
        int y
    ) const;

    void present();

    int getWidth() const;

    int getHeight() const;

private:

    int width;
    int height;

    Uint32* pixels;

    SDL_Renderer* renderer;

    SDL_Texture* texture;
};

}