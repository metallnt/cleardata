package com.github.metallnt.cleardata.commands.manager;

import com.github.metallnt.cleardata.ClearData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class com.github.metallnt.cleardata.commands.manager
 * <p>
 * Date: 12.12.2021 20:08 12 12 2021
 *
 * @author Metall
 */
public class CommandsManager implements TabExecutor {

    private final ClearData plugin;

    private final Map<List<String>, ClearDataCommand> registeredCommands = new LinkedHashMap<>();

    public CommandsManager(final ClearData clearData) {
        this.plugin = clearData;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
