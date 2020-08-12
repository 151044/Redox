package com.colin.games.redox.level;

import com.colin.games.redox.utils.RandomUtils;

import java.util.Random;

public class LevelGenerator {
    public static Level getLevel(int rooms){
        Level toMod = new Level(192,192);
        for(int i = 0; i < rooms; i++){
            toMod.placeRoom(new Room(RandomUtils.rangeBetween(3,40),RandomUtils.rangeBetween(3,40),RandomUtils.rangeBetween(2,190),RandomUtils.rangeBetween(2,190)));
        }
        return toMod;
    }
}
