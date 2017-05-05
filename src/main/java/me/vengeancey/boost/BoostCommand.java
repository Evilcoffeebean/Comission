package me.vengeancey.boost;

import me.vengeancey.boost.utils.PlayerUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Zvijer on 5.5.2017..
 */
public class BoostCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender caller, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("activate")) {
            if (!(caller instanceof Player))
                return true;
            Player player = (Player) caller;
            boolean active, combat;
            active = Boost.getInstance().getActivationManager().isActive(player);
            combat = Boost.getInstance().getCombatManager().isActive(player);
            if (!active) {
                if (!combat) {
                    Boost.getInstance().getActivationManager().activatePlayer(player);
                    PlayerUtil.launchPlayer(player, 7);
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "You are currently in combat.");
                    return true;
                }
            }
        }
        return true;
    }
}
