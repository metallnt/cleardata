package com.github.metallnt.cleardata.actions;

import com.github.metallnt.cleardata.ClearData;
import com.gmail.nossr50.mcMMO;
import com.gmail.nossr50.util.commands.CommandUtils;
import com.gmail.nossr50.util.player.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.Objects;
import java.util.UUID;

/**
 * Class com.github.metallnt.cleardata.actions
 * <p>
 * Date: 20.12.2021 14:29 20 12 2021
 *
 * @author Metall
 */
public class McMmoClear {

    private final ClearData plugin;
    private mcMMO api;

    public McMmoClear(ClearData plugin) {
        this.plugin = plugin;
    }

    private void clearData(String player) {
        RegisteredServiceProvider<mcMMO> provider = Bukkit.getServicesManager().getRegistration(mcMMO.class);
        if (provider != null) {
//            api = provider.getProvider();
            if (UserManager.getOfflinePlayer(player) == null && CommandUtils.unloadedProfile(plugin.getServer().getConsoleSender(), mcMMO.getDatabaseManager().loadPlayerProfile(player))) {
                return;
            }
            UUID uuid = null;
            if (Bukkit.getPlayer(player) != null) {
                uuid = Objects.requireNonNull(Bukkit.getPlayer(player)).getUniqueId();
            }
            if (mcMMO.getDatabaseManager().removeUser(player, uuid)) {
                plugin.getServer().getConsoleSender().sendMessage("Данные " + player + " успешно удалены из mcMMO");
            } else {
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Данные " + player + " не удалось удалить из mcMMO");
            }
        }
    }

    public void clear(String player) {
        if (plugin.getSettingsConfig().getMcMmo()) {
            clearData(player);
            plugin.getServer().getConsoleSender().sendMessage("Из плагина McMMO удалены данные игрока " + player);
        } else {
            plugin.getServer().getConsoleSender().sendMessage("Очистка McMMO отключена в конфиге");
        }
    }
}
