package com.colin.games.redox.level.tile;

import com.colin.games.redox.level.Tile;
import com.colin.games.redox.utils.Point;

public class Wall extends Tile {

    public Wall(Point p) {
        super(p);
    }

    @Override
    public boolean isPassable() {
        return false;
    }
}
