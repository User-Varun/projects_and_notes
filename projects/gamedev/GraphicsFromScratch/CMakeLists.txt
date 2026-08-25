cmake_minimum_required(VERSION 3.16)

project(GraphicsFromScratch)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# --------------------------------------------------
# Find SDL2
# --------------------------------------------------

find_package(SDL2 REQUIRED)

# --------------------------------------------------
# Include header files
# --------------------------------------------------

include_directories(include)

# --------------------------------------------------
# Source files
# --------------------------------------------------

set(SOURCES

    src/main.cpp

    src/Graphics/FrameBuffer.cpp
    src/Graphics/Fill.cpp

    src/Graphics/Line.cpp
    src/Graphics/Circle.cpp
    src/Graphics/Polygon.cpp

)

# --------------------------------------------------
# Create executable
# --------------------------------------------------

add_executable(GraphicsFromScratch
    ${SOURCES}
)

# --------------------------------------------------
# Link SDL2
# --------------------------------------------------

target_link_libraries(GraphicsFromScratch
    PRIVATE
    SDL2::SDL2
)
