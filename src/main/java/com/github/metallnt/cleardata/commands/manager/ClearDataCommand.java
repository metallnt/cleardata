package com.github.metallnt.cleardata.commands.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.Plugin;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Class com.github.metallnt.cleardata.commands.manager
 * <p>
 * Date: 12.12.2021 20:19 12 12 2021
 *
 * @author Metall
 */
public abstract class ClearDataCommand implements TabExecutor {

    public abstract String getDescription();
    public abstract String getPermission();
    public abstract String getUsage();


    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        return null;
    }

    public boolean hasPermission(String permission, CommandSender sender) {
        if (!sender.hasPermission(permission)) {
            sender.sendMessage(ChatColor.RED + "You don't have permission!");
            return false;
        }
        return true;
    }

    public static List<String> getArgumentOptions(String[] strings) {
        List<String> arguments = new ArrayList<>();

        Arrays.stream(strings).forEach(string -> {
            if (string.matches("[-]{2}[a-zA-Z_-]+")) {
                arguments.add(string.replace("--", "").toLowerCase());
            }
        });
        return arguments;
    }

    public void runCommandTask(CompletableFuture<?> task) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("ClearData");
        assert plugin != null;
        Bukkit.getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                task.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    public static List<String> getOptionsStartingWith(Collection<String> options, String started) {
        return options.stream().filter(s -> s.toLowerCase().startsWith(started.toLowerCase())).collect(Collectors.toList());
    }

    public static String getStringFromArgs(final String[] args, final int startArg) {
        final StringBuilder string = new StringBuilder();
        for (int i = startArg; i < args.length; i++) {
            if (i == startArg) {
                string.append(args[i]);
            } else {
                string.append(" ").append(args[i]);
            }
        }
        return string.toString();
    }
}
