package me.vengeancey.boost.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Zvijer on 5.5.2017..
 */
public abstract class ConfigUtil {
    private File file;
    private FileConfiguration config;

    public ConfigUtil(File file) {
        this.file = file;
        this.config = YamlConfiguration.loadConfiguration(file);
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final void init() throws IOException {
        if (!file.exists()) {
            config.save(file);
        } else {
            config = YamlConfiguration.loadConfiguration(file);
        }
    }

    public <T> void set(String path, T value) throws IOException, NullPointerException {
        if (config != null && file.exists()) {
            config.set(path, value);
            config.save(file);
        }
    }

    public <T> T get(String path) throws ClassCastException, NullPointerException {
        return (T) config.get(path);
    }
}
