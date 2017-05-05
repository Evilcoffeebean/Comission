package me.vengeancey.boost.utils;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by Zvijer on 5.5.2017..
 */
public class PlayerUtil {

    public static void launchPlayer(Player player, double distance) {
        double x = player.getVelocity().getX();
        double z = player.getVelocity().getZ();
        player.setVelocity(new Vector(x, distance, z));
    }
}
