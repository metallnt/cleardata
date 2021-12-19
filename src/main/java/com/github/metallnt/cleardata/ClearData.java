package com.github.metallnt.cleardata;

import com.github.metallnt.cleardata.Listeners.PlayerDeathListener;
import com.github.metallnt.cleardata.Listeners.RebootListener;
import com.github.metallnt.cleardata.actions.AutorankClear;
import com.github.metallnt.cleardata.actions.Logics;
import com.github.metallnt.cleardata.configs.SettingsConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClearData extends JavaPlugin {

    private static ClearData cleardata;

    // Configs
    private SettingsConfig settingsConfig;

    private RebootListener rebootListener;
    private PlayerDeathListener playerDeathListener;
    private Logics logics;
    private AutorankClear autorankClear;

    public static ClearData getInstance() {
        return cleardata;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        cleardata = this;

        // Register configs
        setSettingsConfig(new SettingsConfig(this));

        setRebootListener(new RebootListener(this));
        setPlayerDeathListener(new PlayerDeathListener(this));
        setLogics(new Logics(this));
        setAutorankClear(new AutorankClear(this));

        // Load settings config
        if (!this.getSettingsConfig().loadConfig()) {
            this.getServer().getConsoleSender().sendMessage("Конфиг не загружен!");
        }

        if (this.getSettingsConfig().updateConfigWithNewOptions()) {
            this.getServer().getConsoleSender().sendMessage("Конфиг обновлен");
        } else {
            this.getServer().getConsoleSender().sendMessage("Конфиг не смог обновиться");
        }

//        new PlayerDeathListener(this);
        if (getSettingsConfig().getCheckReboot()) {
            rebootListener.onReboot();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
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

    public RebootListener getRebootListener() {
        return rebootListener;
    }

    public void setRebootListener(RebootListener rebootListener) {
        this.rebootListener = rebootListener;
    }

    public PlayerDeathListener getPlayerDeathListener() {
        return playerDeathListener;
    }

    public void setPlayerDeathListener(PlayerDeathListener playerDeathListener) {
        this.playerDeathListener = playerDeathListener;
    }

    public Logics getLogics() {
        return logics;
    }

    public void setLogics(Logics logics) {
        this.logics = logics;
    }

    public AutorankClear getAutorankClear() {
        return autorankClear;
    }

    public void setAutorankClear(AutorankClear autorankClear) {
        this.autorankClear = autorankClear;
    }
}
