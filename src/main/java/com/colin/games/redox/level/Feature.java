package com.colin.games.redox.level;

import com.colin.games.redox.actor.player.Player;

public interface Feature {
    void interact(Player p);
    String desc();
}
