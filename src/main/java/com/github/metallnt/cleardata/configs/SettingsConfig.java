package com.github.metallnt.cleardata.configs;

import com.github.metallnt.cleardata.ClearData;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

/**
 * Class com.github.metallnt.cleardata.configs
 * <p>
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
}
