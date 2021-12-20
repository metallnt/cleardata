package com.github.metallnt.cleardata.actions;

import com.github.metallnt.cleardata.ClearData;
import me.armar.plugins.autorank.Autorank;
import me.armar.plugins.autorank.util.uuid.UUIDManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

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

    private void clearPaths(String player) {
        Autorank autorank = getAutorank();
        UUID uuid = null;
        try {
            uuid = UUIDManager.getUUID(player).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        if (uuid == null) {
            plugin.getServer().getConsoleSender().sendMessage("Игрок " + player + " не существует");
            return;
        }
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "autorank gset " + player + " 0");
        assert autorank != null;
        autorank.getPathManager().resetAllProgress(uuid);
        plugin.getServer().getConsoleSender().sendMessage("Сброшен прогресс активных и завершенных путей у игрока " + player);
    }

    private Autorank getAutorank() {
        Plugin autorank = plugin.getServer().getPluginManager().getPlugin("Autorank");
        if (!(autorank instanceof Autorank)) {
            plugin.getServer().getConsoleSender().sendMessage("Плагин Autorank не найден");
            return null;
        }
        return (Autorank) autorank;
    }

    public void clear(String player) {
        if (plugin.getSettingsConfig().getAutorank()) {
            clearPaths(player);
            plugin.getServer().getConsoleSender().sendMessage("Из плагина Autorank удалены данные игрока " + player);
        } else {
            plugin.getServer().getConsoleSender().sendMessage("Очистка Autorank отключена в конфиге");
        }
    }
}
