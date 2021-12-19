package com.github.metallnt.cleardata.configs;

import com.github.metallnt.cleardata.ClearData;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ConcurrentModificationException;

/**
 * Class com.github.metallnt.cleardata.configs
 * <p>
 * Date: 10.12.2021 16:39 10 12 2021
 *
 * @author Metall
 */
public class YamlConfig extends YamlConfiguration {
    File file;

    // Create New YAML File
    public YamlConfig(final ClearData plugin, final String fileName) throws InvalidConfigurationException {
        final String folderPath = plugin.getDataFolder().getAbsolutePath() + File.separator;
        file = new File(folderPath + fileName);

        if (!file.exists()) {
            if (plugin.getResource(fileName) != null) {
                plugin.saveResource(fileName, false);
                try {
                    this.load(file);
                } catch (final Exception e) {
                    throw new InvalidConfigurationException(e.getMessage());
                }
            }
        } else {
            try {
                this.load(file);
            } catch (final Exception e) {
                throw new InvalidConfigurationException(e.getMessage());
            }
        }
    }

    // Get internal YAML file
    public File getInternalFile() {
        return file;
    }

    // Load YAML file
    public void loadFile() {
        try {
            this.load(file);
        } catch (final IOException | InvalidConfigurationException ignored) {

        }
    }

    // Save YAML file
    public void saveFile() {
        try {
            if (file == null) {
                ClearData.getInstance().getServer().getConsoleSender().sendMessage("Can't save file, because it's null!");
                return;
            }
            this.save(file);
        } catch (ConcurrentModificationException e) {
            saveFile();
        } catch (NullPointerException npe) {
            ClearData.getInstance().getServer().getConsoleSender().sendMessage("Save file thrown NPE:" + npe.getMessage());
            ClearData.getInstance().getServer().getConsoleSender().sendMessage("FILE TO SAVE: " + file);
            npe.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    // Reload YAML file
    public void reloadFile() {
        loadFile();
        saveFile();
    }
}
