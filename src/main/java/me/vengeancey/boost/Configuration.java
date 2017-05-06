package me.vengeancey.boost;

import me.vengeancey.boost.utils.ConfigUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created by Zvijer on 6.5.2017..
 */
public class Configuration extends ConfigUtil {

    public Configuration() {
        super(new File(Boost.getInstance().getDataFolder(), "config.yml"));
        try {
            set("blocks-to-launch", 7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
