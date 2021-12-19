package com.github.metallnt.cleardata.Listeners;

import com.github.metallnt.cleardata.ClearData;
import com.github.metallnt.cleardata.configs.SettingsConfig;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;
import java.util.logging.Logger;

/**
 * Class com.github.metallnt.cleardata.Listeners
 * <p>
 * Date: 14.12.2021 14:24 14 12 2021
 *
 * @author Metall
 */
public class PlayerDeathListener implements Listener {

    private final ClearData plugin;
//    private final SettingsConfig config;

    public PlayerDeathListener(ClearData clearData) {
        this.plugin = clearData;
        Bukkit.getPluginManager().registerEvents(this, clearData);
    }

    @EventHandler
    public void onPlayerDead(PlayerDeathEvent e) {
        if (plugin.getSettingsConfig().getCheckDeadPlayer()) {
            plugin.getServer().getConsoleSender().sendMessage(" Работает удаление по смерти");
            plugin.getLogics().clearPlayer(Objects.requireNonNull(e.getEntity().getPlayer()).getName());
        }
    }
}
