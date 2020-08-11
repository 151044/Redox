package com.colin.games.redox.level.tile;

import com.colin.games.redox.utils.Point;
import com.colin.games.redox.utils.Sprite;

public class Floor extends Tile{
    public Floor(Point p) {
        super(p);
    }

    @Override
    public char getAscii(Orientation orient) {
        return '.';
    }

    @Override
    public Sprite getSprite(Orientation orient) {
        return null;
    }

    @Override
    public boolean canHaveFeature() {
        return super.canHaveFeature();
    }
}
