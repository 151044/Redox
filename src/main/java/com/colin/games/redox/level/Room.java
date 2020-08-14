package com.colin.games.redox.level;

import com.colin.games.redox.Directional;
import com.colin.games.redox.level.tile.Floor;
import com.colin.games.redox.level.tile.Tile;
import com.colin.games.redox.level.tile.Wall;
import com.colin.games.redox.utils.Point;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
    private String represent;
    private Point scale;
    private List<List<Tile>> tiles = new ArrayList<>();
    public Room(int width, int height, int x, int y){
        this(width,height,new Point(x,y));
    }
    public Room(int width, int height, Point bottom){
        scale = bottom;
        for(int y = 0; y < height; y++){
            tiles.add(new ArrayList<>());
        }
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                tiles.get(y).add(new Wall(new Point(bottom.getX() + x,bottom.getY() + y), Directional.Orientation.DOWN));
            }
        }
        for(int x = 1; x < width - 1; x++){
            for(int y = 1; y < height - 1; y++){
                tiles.get(y).set(x,new Floor(new Point(bottom.getX() + x, bottom.getY() + y)));
            }
        }
        for(int x = 0; x < width; x++){
            tiles.get(0).get(x).setOrientation(Directional.Orientation.RIGHT);
            tiles.get(height - 1).get(x).setOrientation(Directional.Orientation.RIGHT);
        }
    }
    public String dump(){
        return tiles.stream().map(l -> l.stream().map(t -> String.valueOf(t.getActualAscii())).collect(Collectors.joining())).collect(Collectors.joining("\n"));
    }
    public List<Tile> getAllTiles(){
        return tiles.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
    public List<Tile> intersection(Room other){
        List<Tile> intersect = getAllTiles();
        intersect.retainAll(other.getAllTiles());
        return intersect;
    }
    public boolean intersects(Room other){
        return tiles.stream().flatMap(Collection::stream).anyMatch(t -> other.getAllTiles().contains(t));
    }
    public Room clearOverlapping(Room other){
        intersection(other).stream().filter(t -> t instanceof Wall || other.tiles.get(t.getY() - other.scale.getY()).get(t.getX() - other.scale.getX()) instanceof Wall).forEach(t -> {
           Point toOp = t.getLocation();
           tiles.get(toOp.getY() - scale.getY()).set(toOp.getX() - scale.getX(), new Floor(toOp));
           other.tiles.get(toOp.getY() - other.scale.getY()).set(toOp.getX() - other.scale.getX(), new Floor(toOp));
        });
        return this;
    }
}
