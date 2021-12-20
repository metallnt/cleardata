package com.github.metallnt.cleardata.actions;

import com.github.metallnt.cleardata.ClearData;
import org.bukkit.Bukkit;

/**
 * Class com.github.metallnt.cleardata.actions
 * <p>
 * Date: 20.12.2021 13:06 20 12 2021
 *
 * @author Metall
 */
public class LuckPermsClear {

    private final ClearData plugin;

    public LuckPermsClear(ClearData plugin) {
        this.plugin = plugin;
    }

    public void clear(String player) {
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + player + " clear");
        plugin.getServer().getConsoleSender().sendMessage("Из плагина LuckPerms удалены данные игрока " + player);
    }
}
