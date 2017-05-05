package me.vengeancey.boost.utils;

import com.google.common.collect.Lists;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

/**
 * Created by Zvijer on 5.5.2017..
 */
public class CombatManager {
    private static List<UUID> activePlayers = Lists.newArrayList();

    public boolean isActive(Player player) {
        return activePlayers.contains(player.getUniqueId());
    }

    public void activatePlayer(Player player) {
        activePlayers.add(player.getUniqueId());
    }

    public void deactivatePlayer(Player player) {
        activePlayers.remove(player.getUniqueId());
    }

    public void clear() {
        if (!activePlayers.isEmpty())
            activePlayers.clear();
    }

    public void remove(Player player) {
        activePlayers.remove(player.getUniqueId());
    }
}