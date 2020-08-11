package com.colin.games.redox.utils;

import com.colin.games.redox.Launch;

import java.util.Random;

public class RandomUtils {
    private static final Random rand = new Random(Launch.getSeed());
    public static int nextInt(){
        return rand.nextInt();
    }
    public static int rangeBetween(int lo, int hi){
        return rand.nextInt(hi - lo) + lo;
    }
    public static long nextLong(){
        return rand.nextLong();
    }
    public static double nextNormal(double deviate, double mean){
        return rand.nextGaussian() * deviate + mean;
    }
    public static double nextDouble(){
        return rand.nextDouble();
    }
    public static boolean nextBoolean(){
        return rand.nextBoolean();
    }
    public static int dice(int side){
        return rand.nextInt(side) + 1;
    }
}
