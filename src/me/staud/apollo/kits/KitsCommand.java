package me.staud.apollo.kits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class KitsCommand implements CommandExecutor {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cThis command is only executable by players.");
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("kits")) {
            Player p = (Player)sender;
            Inventory kitsgui = Bukkit.createInventory((InventoryHolder)null, 27, "§9Choose Your Kit");
            p.openInventory(kitsgui);
            ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta pvpMeta = pvp.getItemMeta();
            pvpMeta.setDisplayName("§aPvP");
            pvpMeta.setLore((List)Arrays.asList("§7Default PvP class."));
            pvp.setItemMeta(pvpMeta);
            kitsgui.setItem(1, pvp);
            ItemStack archer = new ItemStack(Material.BOW);
            ItemMeta archerMeta = archer.getItemMeta();
            archerMeta.setDisplayName("§dArcher");
            archerMeta.setLore((List)Arrays.asList("§7Bow down your enemies down."));
            archer.setItemMeta(archerMeta);
            kitsgui.setItem(2, archer);
        }
        return true;
    }

}