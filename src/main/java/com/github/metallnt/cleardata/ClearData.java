package com.github.metallnt.cleardata;

import com.github.metallnt.cleardata.commands.manager.CommandsManager;
import com.github.metallnt.cleardata.configs.SettingsConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class ClearData extends JavaPlugin {

    private static ClearData cleardata;
    // Configs
    private SettingsConfig settingsConfig;

    // Managers
    private CommandsManager commandsManager;

    // Plugins variable
    private static boolean vault = false;

    public static ClearData getInstance() {
        return cleardata;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        cleardata = this;

        // Register configs
        setSettingsConfig(new SettingsConfig(this));

        // Load settings config
        if (!this.getSettingsConfig().loadConfig()) {
            this.getServer().getConsoleSender().sendMessage("settings.yml file could not be loaded!");
        }

        // ------------- Initialize managers -------------
        // Create commands manager
        setCommandsManager(new CommandsManager(this));

        // ------------- Initialize other plugins -------------
        this.initializeOtherPlugins();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // ---------- CONVENIENCE METHODS ---------- \\
    //
    //
    //

    private void initializeOtherPlugins() {


        // Vault related
        if (Objects.requireNonNull(getServer().getPluginManager().getPlugin("Vault")).isEnabled()) {
            vault = true;
        }
    }

    // Reload plugin
    public void reload() {
        getServer().getPluginManager().disablePlugin(this);
        getServer().getPluginManager().enablePlugin(this);
    }

    public SettingsConfig getSettingsConfig() {
        return settingsConfig;
    }

    public void setSettingsConfig(SettingsConfig settingsConfig) {
        this.settingsConfig = settingsConfig;
    }

    public CommandsManager getCommandsManager() {
        return commandsManager;
    }

    public void setCommandsManager(final CommandsManager commandsManager) {
        this.commandsManager = commandsManager;
    }
}
