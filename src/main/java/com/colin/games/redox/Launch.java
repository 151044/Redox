package com.colin.games.redox;

import com.colin.games.redox.gui.WelcomeFrame;

import java.util.Random;
public class Launch {
    private Launch(){
        throw new AssertionError("Launch object instantiated!");
    }
    private static long seed = new Random().nextLong();
    public static void main(String[] args) {
        new WelcomeFrame();
    }
    public static long getSeed(){
        return seed;
    }
}
