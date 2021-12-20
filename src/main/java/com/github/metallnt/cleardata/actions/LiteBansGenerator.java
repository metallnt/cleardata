package com.github.metallnt.cleardata.actions;

import com.github.metallnt.cleardata.ClearData;
import org.bukkit.Bukkit;

import java.util.Random;

/**
 * Class com.github.metallnt.cleardata.actions
 * <p>
 * Date: 20.12.2021 13:38 20 12 2021
 *
 * @author Metall
 */
public class LiteBansGenerator {

    private final ClearData plugin;

    public LiteBansGenerator(ClearData plugin) {
        this.plugin = plugin;
    }

    public void make(String player) {
        if (plugin.getSettingsConfig().getLiteBans()) {
            long time = getTime();
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tempban " + player + " " + time + "m Вы погибли");
        }
    }

    private long getTime() {
        long min = plugin.getSettingsConfig().getMinTime() * 60L;
        long max = plugin.getSettingsConfig().getMaxTime() * 60L;
        return (long)Math.floor(Math.random()*(max-min+1)+min);
    }
}
