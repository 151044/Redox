package com.colin.games.redox.level.tile;

import com.colin.games.redox.utils.Point;
import com.colin.games.redox.utils.Sprite;

public class Edge extends Tile{
    public Edge(Point p) {
        super(p, Orientation.DOWN,"Edge");
    }

    @Override
    public char getAscii(Orientation orient) {
        return 'x';
    }

    @Override
    public Sprite getSprite(Orientation orient) {
        return null;
    }

    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public boolean canHaveFeature() {
        return false;
    }

    @Override
    public boolean isDigPossible() {
        return false;
    }
}
