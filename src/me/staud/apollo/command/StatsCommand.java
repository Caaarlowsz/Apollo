package me.staud.apollo.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "ERROR, whilst performing this command.");
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("stats")) {
            if(args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Usage: /" + label + " <player>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null) {
                sender.sendMessage(ChatColor.RED + "ERROR, Player is offline.");
                return true;
            }
            sender.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
            sender.sendMessage(ChatColor.GREEN + "" + target.getName() + "'s stats");
            sender.sendMessage(ChatColor.AQUA + "Kills: " + target.getStatistic(Statistic.PLAYER_KILLS));
            sender.sendMessage(ChatColor.AQUA + "Deaths: " + target.getStatistic(Statistic.DEATHS));
            sender.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
            return true;
        }
        return false;
    }
}
