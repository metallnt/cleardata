package com.github.metallnt.cleardata.Listeners;

import com.github.metallnt.cleardata.ClearData;
import com.github.metallnt.cleardata.actions.Logics;

import java.util.logging.Logger;

/**
 * Class com.github.metallnt.cleardata.Listeners
 * <p>
 * Date: 14.12.2021 11:07 14 12 2021
 *
 * @author Metall
 */
public class RebootListener {

    private final ClearData plugin;
    public RebootListener(ClearData clearData) {
        this.plugin = clearData;
    }

    // При перезагрузке
    public void onReboot() {
        if (plugin.getSettingsConfig().getCheckReboot()) {
            plugin.getServer().getConsoleSender().sendMessage("Работает удаление по перезагрузке");
        } else {
            plugin.getServer().getConsoleSender().sendMessage("Отключено удаление по перезагрузке");
        }
    }
}
