package com.github.metallnt.cleardata.actions;

import com.github.metallnt.cleardata.ClearData;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.Objects;
import java.util.UUID;

/**
 * Class com.github.metallnt.cleardata.actions
 * <p>
 * Date: 20.12.2021 13:06 20 12 2021
 *
 * @author Metall
 */
public class LuckPermsClear {

    private final ClearData plugin;
    private LuckPerms api;

    public LuckPermsClear(ClearData plugin) {
        this.plugin = plugin;
    }

    private void clearData(String player) {
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            api = provider.getProvider();
            UUID uuid = Objects.requireNonNull(api.getUserManager().getUser(player)).getUniqueId();
            api.getUserManager().deletePlayerData(uuid);
        }
    }

    public void clear(String player) {
        if (plugin.getSettingsConfig().getLuckPerms()) {
            clearData(player);
            plugin.getServer().getConsoleSender().sendMessage("Из плагина LuckPerms удалены данные игрока " + player);
        } else {
            plugin.getServer().getConsoleSender().sendMessage("Очистка данных LuckPerms отключена в конфиге");
        }
    }
}
