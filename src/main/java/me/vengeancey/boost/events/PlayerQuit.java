package me.vengeancey.boost.events;

import me.vengeancey.boost.Boost;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Zvijer on 5.5.2017..
 */
public class PlayerQuit implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        boolean active = Boost.getInstance().getActivationManager().isActive(e.getPlayer());
        boolean combat = Boost.getInstance().getCombatManager().isActive(e.getPlayer());
        if (active)
            Boost.getInstance().getActivationManager().remove(e.getPlayer());
        if (combat)
            Boost.getInstance().getActivationManager().remove(e.getPlayer());
    }
}
