package me.staud.apollo.command;

import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCommand implements CommandExecutor {

    private Object message;
    private Object String;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "ERROR, whilst performing that command.");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /" + label + " <player>");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "ERROR, You can't report a player who is currently offline.");
            return true;
        }
        if (sender.hasPermission("apollo.report")) {
            sender.sendMessage(ChatColor.BLUE + "[Report]" + ChatColor.GRAY + " [KitPvP] " + ChatColor.AQUA + "Username: " + target.getName());
            String reason = StringUtils.join(args, ' ', 1, args.length);
            sender.sendMessage(ChatColor.RED +  "Reason: " + reason);
        }
        sender.sendMessage(ChatColor.GREEN + "Your report has now been sent to all available staff members.");
        return false;
    }
}
