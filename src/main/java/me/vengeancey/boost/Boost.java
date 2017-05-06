package me.vengeancey.boost;

import lombok.Getter;
import me.vengeancey.boost.events.PlayerDamage;
import me.vengeancey.boost.events.PlayerFall;
import me.vengeancey.boost.events.PlayerQuit;
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
    private @Getter Configuration configuration;

    @Override
    public void onEnable() {
        instance = this;
        activationManager = new ActivationManager();
        combatManager = new CombatManager();
        configuration = new Configuration();
        Stream.of(
                new PlayerDamage(),
                new PlayerFall(),
                new PlayerQuit()
        ).forEach(event -> getServer().getPluginManager().registerEvents(event, this));
        getCommand("activate").setExecutor(new BoostCommand(configuration));
    }

    @Override
    public void onDisable() {
        activationManager.clear();
        combatManager.clear();
    }
}
