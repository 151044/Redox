package com.colin.games.redox.level;

import com.colin.games.redox.level.tile.Edge;
import com.colin.games.redox.level.tile.Rock;
import com.colin.games.redox.level.tile.Tile;
import com.colin.games.redox.utils.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Level {
    private List<List<Tile>> tiles = new ArrayList<>();
    public Level(int width, int height){
        for(int y = 0; y < height; y++){
            tiles.add(new ArrayList<>());
        }
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                tiles.get(y).add(new Edge(new Point(x,y)));
            }
        }
        for(int x = 1; x < width - 1; x++){
            for(int y = 1; y < height - 1; y++){
                tiles.get(y).set(x,new Rock(new Point(x,y)));
            }
        }
    }
    public String dump(){
        return tiles.stream().map(l -> l.stream().map(t -> String.valueOf(t.getActualAscii())).collect(Collectors.joining())).collect(Collectors.joining("\n"));
    }
    public Level placeRoom(Room r){
        r.getAllTiles().forEach(t -> tiles.get(t.getY()).set(t.getX(),t));
        return this;
    }
}
