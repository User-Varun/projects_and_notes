#include "Graphics/FrameBuffer.h"
#include "Graphics/Color.h"
#include <iostream>

namespace Graphics
{

    FrameBuffer::FrameBuffer(
        SDL_Renderer *renderer,
        int width,
        int height)
    {
        this->renderer = renderer;
        this->width = width;
        this->height = height;

        pixels = new Uint32[width * height];

        clear(Graphics::BLACK);

        texture = SDL_CreateTexture(renderer, SDL_PIXELFORMAT_ARGB8888, SDL_TEXTUREACCESS_STREAMING, width, height);

        if (!texture)
        {
            std::cerr << SDL_GetError() << std::endl;
        }
    }

    FrameBuffer::~FrameBuffer()
    {
        delete[] pixels;
        SDL_DestroyTexture(texture);
    }

    void FrameBuffer::clear(Uint32 color)
    {
        for (int i = 0; i < width * height; i++)
        {
            pixels[i] = color;
        }
    }

    void FrameBuffer::putPixel(
        int x,
        int y,
        Uint32 color)
    {
        if (x < 0 || x >= width || y < 0 || y >= height)
            return;

        pixels[y * width + x] = color;
    }

    Uint32 FrameBuffer::getPixel(
        int x,
        int y) const
    {
        if (x < 0 || x >= width || y < 0 || y >= height)
            return 0;

        return pixels[y * width + x];
    }

    void FrameBuffer::present()
    {
        SDL_UpdateTexture(
            texture,
            nullptr,
            pixels,
            width * sizeof(Uint32));

        SDL_RenderClear(renderer);

        SDL_RenderCopy(
            renderer,
            texture,
            nullptr,
            nullptr);

        SDL_RenderPresent(renderer);
    }

    int FrameBuffer::getWidth() const
    {
        return width;
    }

    int FrameBuffer::getHeight() const
    {
        return height;
    }

}