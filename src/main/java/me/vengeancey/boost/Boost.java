package me.vengeancey.boost;

import lombok.Getter;
import me.vengeancey.boost.events.PlayerDamage;
import me.vengeancey.boost.events.PlayerFall;
import me.vengeancey.boost.utils.ActivationManager;
import me.vengeancey.boost.utils.CombatManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.stream.Stream;

/**
 * Created by Zvijer on 5.5.2017..
 */
public class Boost extends JavaPlugin {
    private static @Getter Boost instance;
    private @Getter ActivationManager activationManager;
    private @Getter CombatManager combatManager;

    @Override
    public void onEnable() {
        instance = this;
        activationManager = new ActivationManager();
        combatManager = new CombatManager();
        Stream.of(
                new PlayerDamage(),
                new PlayerFall()
        ).forEach(event -> getServer().getPluginManager().registerEvents(event, this));
        getCommand("activate").setExecutor(new BoostCommand());
    }

    @Override
    public void onDisable() {
        activationManager.clear();
        combatManager.clear();
    }
}
