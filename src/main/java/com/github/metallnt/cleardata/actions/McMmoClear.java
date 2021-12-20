package com.github.metallnt.cleardata.actions;

import com.github.metallnt.cleardata.ClearData;
import org.bukkit.Bukkit;

/**
 * Class com.github.metallnt.cleardata.actions
 * <p>
 * Date: 20.12.2021 14:29 20 12 2021
 *
 * @author Metall
 */
public class McMmoClear {

    private final ClearData plugin;

    public McMmoClear(ClearData plugin) {
        this.plugin = plugin;
    }

    public void clear(String player) {
        if (plugin.getSettingsConfig().getMcMmo()) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mcremove " + player);
            plugin.getServer().getConsoleSender().sendMessage("Из плагина McMMO удалены данные игрока " + player);
        } else {
            plugin.getServer().getConsoleSender().sendMessage("Очистка McMMO отключена в конфиге");
        }
    }
}
