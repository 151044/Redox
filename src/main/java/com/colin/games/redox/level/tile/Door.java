package com.colin.games.redox.level.tile;

import com.colin.games.redox.utils.Point;
import com.colin.games.redox.utils.Sprite;

public class Door extends Tile{
    private boolean isOpen = false;
    public Door(Point p) {
        super(p);
    }

    @Override
    public char getAscii(Orientation orient) {
        return isOpen ? ' ' : '+';
    }

    @Override
    public Sprite getSprite(Orientation orient) {
        return null;
    }

    @Override
    public boolean canHaveFeature() {
        return false;
    }
}
