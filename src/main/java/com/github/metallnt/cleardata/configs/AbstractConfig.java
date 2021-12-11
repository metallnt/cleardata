package com.github.metallnt.cleardata.configs;

import com.github.metallnt.cleardata.ClearData;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Class com.github.metallnt.cleardata.configs
 * <p>
 * Date: 10.12.2021 16:38 10 12 2021
 *
 * @author Metall
 */
public class AbstractConfig {

    private YamlConfig configFile;
    private ClearData plugin;
    private String fileName;

    private boolean isLoaded = false;

    // Create New config file
    public void createNewFile() throws InvalidConfigurationException {
        configFile = new YamlConfig(plugin, fileName, fileName);
        plugin.getServer().getConsoleSender().sendMessage("File loaded (" + fileName + ")");
    }

    // Get YAML file
    public FileConfiguration getConfig() {
        if (configFile != null) {
            return configFile;
        }
        return null;
    }

    // Reload YAML file
    public void reloadConfig() {
        if (configFile != null) {
            configFile.reloadFile();
        }
    }

    // Save YAML file
    public void saveConfig() {
        if (configFile == null) {
            return;
        }
        configFile.saveFile();
    }

    // Load YAML file
    public boolean loadConfig() {
        try {
            this.createNewFile();
            isLoaded = true;
        } catch (Exception e) {
            isLoaded = false;
            return false;
        }
        return true;
    }

    // Check loaded config file
    public boolean isLoaded() {
        return isLoaded;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ClearData getPlugin() {
        return plugin;
    }

    public void setPlugin(ClearData plugin) {
        this.plugin = plugin;
    }
}
