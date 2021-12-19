package com.github.metallnt.cleardata.actions;

import com.github.metallnt.cleardata.ClearData;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

/**
 * Class com.github.metallnt.cleardata.actions
 * <p>
 * Date: 19.12.2021 21:20 19 12 2021
 *
 * @author Metall
 */
public class AutorankClear {

    private final ClearData plugin;
    public AutorankClear(ClearData clearData) {
        this.plugin = clearData;
    }

    public void clear(String player) {
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "autorank gset " + player + " 0");
        Bukkit.getServer().dispatchCommand(Objects.requireNonNull(Bukkit.getServer().getPlayer(player)), "autorank deactivate Воин");
        Bukkit.getServer().dispatchCommand(Objects.requireNonNull(Bukkit.getServer().getPlayer(player)), "autorank deactivate Шахтер");
        Bukkit.getServer().dispatchCommand(Objects.requireNonNull(Bukkit.getServer().getPlayer(player)), "autorank deactivate Плотник");
        Bukkit.getServer().dispatchCommand(Objects.requireNonNull(Bukkit.getServer().getPlayer(player)), "autorank deactivate Мастер");
        Bukkit.getServer().dispatchCommand(Objects.requireNonNull(Bukkit.getServer().getPlayer(player)), "autorank deactivate Маг");
        Bukkit.getServer().dispatchCommand(Objects.requireNonNull(Bukkit.getServer().getPlayer(player)), "autorank deactivate Кузнец");
        plugin.getServer().getConsoleSender().sendMessage("Из плагина Autorank удалены данные игрока " + player);
    }
}
