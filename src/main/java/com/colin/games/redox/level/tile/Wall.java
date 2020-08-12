package com.colin.games.redox.level.tile;

import com.colin.games.redox.Directional;
import com.colin.games.redox.utils.Point;
import com.colin.games.redox.utils.Sprite;

public class Wall extends Tile {

    public Wall(Point p,Orientation orient) {
        super(p,orient);
    }

    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public char getAscii(Orientation orient) {
        if(orient == Orientation.DOWN || orient == Orientation.UP){
            return '|';
        }else{
            return '-';
        }
    }

    @Override
    public Sprite getSprite(Orientation orient) {
        return null;
    }

}
