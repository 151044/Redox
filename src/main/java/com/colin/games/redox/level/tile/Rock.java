package com.colin.games.redox.level.tile;

import com.colin.games.redox.utils.Point;
import com.colin.games.redox.utils.Sprite;

public class Rock extends Tile{
    public Rock(Point p) {
        super(p, Orientation.DOWN,"Rock");
    }

    @Override
    public char getAscii(Orientation orient) {
        return ' ';
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
