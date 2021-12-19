package com.github.metallnt.cleardata.actions;

import com.github.metallnt.cleardata.ClearData;
import com.github.metallnt.cleardata.configs.SettingsConfig;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Class com.github.metallnt.cleardata.actions
 * <p>
 * Date: 14.12.2021 11:23 14 12 2021
 *
 * @author Metall
 */
public class Logics {

    private final ClearData plugin;
    private final SettingsConfig config;

    public Logics(ClearData clearData) {
        this.plugin = clearData;
        this.config = clearData.getSettingsConfig();
    }

    // Очистка с учетом времени оффлайна
    public void clearOld() {
        long period = config.getPeriod() * 2592000000L;
        for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
            Player player = offlinePlayer.getPlayer();
            assert player != null;
            long lastTime = player.getLastPlayed();
            long nowTime = new Date().getTime();
            long time = nowTime - lastTime;
            if (time >= period) {
                clearPlayer(player.getName());
            }

        }
    }

    // Очистка данных игрока
    public void clearPlayer(String playerName) {

        plugin.getServer().getConsoleSender().sendMessage("Очистка данных игрока: " + playerName);

        // Вписываем все системы очистки
        if (Bukkit.getPluginManager().isPluginEnabled("Autorank")) {
                plugin.getAutorankClear().clear(playerName);
        }
    }
}