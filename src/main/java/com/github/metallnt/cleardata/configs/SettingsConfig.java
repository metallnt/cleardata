package com.github.metallnt.cleardata.configs;

import com.github.metallnt.cleardata.ClearData;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Class com.github.metallnt.cleardata.configs
 *
 * Date: 11.12.2021 9:53 11 12 2021
 *
 * @author Metall
 */
public class SettingsConfig extends AbstractConfig {

    private final String fileName = "settings.yml";

    public SettingsConfig(final ClearData instance) {
        this.setFileName(fileName);
        this.setPlugin(instance);
    }

    // Update config with NEW options
    public boolean updateConfigWithNewOptions() {
        File settingsFile = new File(this.getPlugin().getDataFolder(), fileName);

        try {
            ConfigUpdater.update(this.getPlugin(), fileName, settingsFile, Collections.emptyList());
            this.reloadConfig();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void reloadConfig() {
        this.loadConfig();
    }

    // More get values key from config
    public boolean getCheckReboot() {
        return this.getConfig().getBoolean("reboot", true);
    }

    public boolean getCheckDeadPlayer() {
        return this.getConfig().getBoolean("dead_player", true);
    }

    public int getPeriod() {
        return this.getConfig().getInt("period_oil");
    }

    public List<String> getWhiteList() {
        return this.getConfig().getStringList("whitelist");
    }

    public boolean getAutorank() {
        return this.getConfig().getBoolean("autorank", true);
    }

    public boolean getLuckPerms() {
        return this.getConfig().getBoolean("luckperms", true);
    }

    public boolean getLiteBans() {
        return this.getConfig().getBoolean("litebans", true);
    }

    public int getMinTime() {
        return this.getConfig().getInt("min_time");
    }

    public int getMaxTime() {
        return this.getConfig().getInt("max_time");
    }
}
