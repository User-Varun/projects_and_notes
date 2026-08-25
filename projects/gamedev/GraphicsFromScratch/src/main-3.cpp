#define SDL_MAIN_HANDLED
#include <SDL2/SDL.h>
#include <iostream>

int main()
{
    int WIDTH = 800;
    int HEIGHT = 600;
    int numPoints = 4;

    SDL_Point polygon[] =
        {
            {200, 100},
            {400, 150},
            {350, 300},
            {150, 250}};

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
        }

        SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
        SDL_RenderClear(renderer);

        SDL_SetRenderDrawColor(renderer, 255, 255, 255, 255);

        

        for (int i = 0; i < numPoints; i++)
        {
            int next = (i + 1) % numPoints;

            SDL_RenderDrawLine(
                renderer,
                polygon[i].x,
                polygon[i].y,
                polygon[next].x,
                polygon[next].y);
        }

        SDL_RenderPresent(renderer);
    }

    SDL_DestroyWindow(window);
    SDL_DestroyRenderer(renderer);
    SDL_Quit();

    return 0;
}
