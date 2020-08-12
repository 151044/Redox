package com.colin.games.redox;

import com.colin.games.redox.level.Level;
import com.colin.games.redox.level.LevelGenerator;
import com.colin.games.redox.level.Room;

import java.util.Random;
public class Launch {
    private Launch(){
        throw new AssertionError("Launch object instantiated!");
    }
    private static long seed = new Random().nextLong();
    public static void main(String[] args) {
        System.out.println(LevelGenerator.getLevel(20).dump());
    }
    public static long getSeed(){
        return seed;
    }
}
