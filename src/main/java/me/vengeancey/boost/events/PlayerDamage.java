package me.vengeancey.boost.events;

import me.vengeancey.boost.Boost;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Zvijer on 5.5.2017..
 */
public class PlayerDamage implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            Player victim = (Player) e.getEntity();
            boolean combat = Boost.getInstance().getCombatManager().isActive(victim);
            if (!combat) {
                Boost.getInstance().getCombatManager().activatePlayer(victim);
                new BukkitRunnable() {
                    double t = 0;
                    @Override
                    public void run() {
                        t++;
                        if (t >= 5) {
                            this.cancel();
                            Boost.getInstance().getCombatManager().deactivatePlayer(victim);
                        }
                    }
                }.runTaskTimer(Boost.getInstance(), 0L, 20L);
            }
        }
    }
}
