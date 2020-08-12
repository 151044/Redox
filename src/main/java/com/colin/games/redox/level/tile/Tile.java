package com.colin.games.redox.level.tile;

import com.colin.games.redox.Directional;
import com.colin.games.redox.actor.player.Player;
import com.colin.games.redox.level.feature.Feature;
import com.colin.games.redox.utils.Point;

import java.util.Objects;
import java.util.Optional;

public abstract class Tile implements Directional{
    private Point location;
    private Feature feature = null;
    private Orientation orient;
    public Tile(Point p,Orientation orient){
        location = p;
        this.orient = orient;
    }
    public Tile(Point p,Feature feature,Orientation orient){
        this.feature = feature;
        location = p;
        this.orient = orient;
    }
    public boolean hasFeature(){
        return feature == null;
    }
    public Optional<Feature> getFeature(){
        return feature == null ? Optional.empty() : Optional.of(feature);
    }
    public void interact(Player p){
        if(feature != null){
            feature.interact(p);
        }
    }
    public boolean isPassable(){
        return true;
    }
    public Point getLocation(){
        return location;
    }

    public boolean canHaveFeature(){
        return feature == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return Objects.equals(location, tile.location) &&
                feature.equals(tile.feature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, feature);
    }
    public Orientation getOrientation(){
        return orient;
    }
    public char getActualAscii(){
        return getAscii(orient);
    }
    public void setOrientation(Orientation orientation){
        orient = orientation;
    }
    public boolean isDigPossible(){
        return true;
    }
    public int getX(){
        return location.getX();
    }
    public int getY(){
        return location.getY();
    }
}
