package me.vengeancey.boost.events;

import me.vengeancey.boost.Boost;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Zvijer on 5.5.2017..
 */
public class PlayerFall implements Listener {
    @EventHandler
    public void onFall(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                boolean active = Boost.getInstance().getActivationManager().isActive(player);
                if (active) {
                    e.setCancelled(true);
                    Boost.getInstance().getActivationManager().deactivatePlayer(player);
                }
            }
        }
    }
}
