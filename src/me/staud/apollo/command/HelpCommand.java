package me.staud.apollo.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("apollo.help")) {
            sender.sendMessage(ChatColor.RED + "ERROR, whilst performing this command.");
            return true;
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m------------------------------------------------"));
        sender.sendMessage(ChatColor.AQUA + "Help Page");
        sender.sendMessage(ChatColor.GRAY  + "");
        sender.sendMessage(ChatColor.BLUE + "» Server Discord: discord.io/apollohq");
        sender.sendMessage(ChatColor.BLUE + "» Server Store: store.apollohq.club");
        sender.sendMessage(ChatColor.BLUE + "» Server Website: www.apollohq.club");
        sender.sendMessage(ChatColor.BLUE + "» Server TS: ts.apollohq.club");
        sender.sendMessage(ChatColor.GRAY + "");
        sender.sendMessage(ChatColor.GREEN + "Useful Commands");
        sender.sendMessage(ChatColor.BLUE + "/discord");
        sender.sendMessage(ChatColor.BLUE + "/store");
        sender.sendMessage(ChatColor.BLUE + "/report");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m------------------------------------------------"));
        return false;
    }
}
