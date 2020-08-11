package com.colin.games.redox.level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Room {
    private String shape;
    private List<Tile> tiles;
    public Room(int length, int width){
        if(length < 0 || width < 0){
            throw new IllegalArgumentException("Length or width is negative in Room constructor!");
        }

    }
    public Room(String desc){

    }
    private Room(List<Tile> tiles){
        tiles = new ArrayList<>(tiles);
    }
    public Room union(Room other){
        Set<Tile> tile = new HashSet<>(tiles);
        tile.addAll(other.tiles);
        return new Room(new ArrayList<>(tile));
    }
    public boolean intersects(Room other){
        return tiles.stream().anyMatch(t -> other.tiles.contains(t));
    }
    public List<Tile> getIntersects(Room other){
        return tiles.stream().filter(t -> other.tiles.contains(t)).collect(Collectors.toList());
    }
    public void makeDoorAt(){

    }
}
