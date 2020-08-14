package com.colin.games.redox.level;

import com.colin.games.redox.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class LevelGenerator {
    public static Level getLevel(int rooms){
        Level toMod = new Level(192,192);
        List<Room> prelim = new ArrayList<>();
        for(int i = 0; i < rooms; i++){
            int width = RandomUtils.rangeBetween(15,40);
            int height = RandomUtils.rangeBetween(8,30);
            Room temp = new Room(width,height,RandomUtils.rangeBetween(2,191 - width),RandomUtils.rangeBetween(2,191 - height));
            prelim.add(temp);
        }
        if(rooms < 60) {
            for (Room r : prelim) {
                for (Room check : prelim) {
                    if (r == check) {
                        continue;
                    }
                    r.clearOverlapping(check);
                }
            }
        }
        for(Room finalized : prelim){
            toMod.placeRoom(finalized);
        }
        return toMod;
    }
}
