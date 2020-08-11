package com.colin.games.redox;

import com.colin.games.redox.utils.Sprite;

public interface Directional {
    enum Orientation{
        LEFT,RIGHT,UP,DOWN
    }
    char getAscii(Orientation orient);
    Sprite getSprite(Orientation orient);
}
