package com.github.metallnt.cleardata;

import com.github.metallnt.cleardata.configs.SettingsConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClearData extends JavaPlugin {

    private static ClearData cleardata;
    // Configs
    private SettingsConfig settingsConfig;

    public static ClearData getInstance() {
        return cleardata;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
