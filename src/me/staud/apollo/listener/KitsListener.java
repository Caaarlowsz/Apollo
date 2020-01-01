package me.staud.apollo.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KitsListener implements Listener {

    public void KitsCommand() {
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onClick(InventoryClickEvent e) {
        ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta pvpMeta = pvp.getItemMeta();
        pvpMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        pvpMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        pvp.setItemMeta(pvpMeta);
        ItemStack archerhelmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta archerhelmetMeta = archerhelmet.getItemMeta();
        archerhelmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        archerhelmetMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        archerhelmet.setItemMeta(archerhelmetMeta);
        ItemStack archerchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta archerchestplateMeta = archerchestplate.getItemMeta();
        archerchestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        archerchestplateMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        archerchestplate.setItemMeta(archerchestplateMeta);
        ItemStack archerleggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta archerleggingsMeta = archerleggings.getItemMeta();
        archerleggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        archerleggingsMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        archerleggings.setItemMeta(archerleggingsMeta);
        ItemStack archerboots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta archerbootsMeta = archerboots.getItemMeta();
        archerbootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        archerbootsMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        archerboots.setItemMeta(archerbootsMeta);
        ItemStack archersword = new ItemStack(Material.WOOD_SWORD);
        ItemMeta archerswordMeta = archersword.getItemMeta();
        archerswordMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
        archerswordMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        archersword.setItemMeta(archerswordMeta);
        ItemStack archerbow = new ItemStack(Material.BOW);
        ItemMeta archerbowMeta = archerbow.getItemMeta();
        archerbowMeta.setDisplayName("§dBow");
        archerbowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
        archerbowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        archerbowMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        archerbow.setItemMeta(archerbowMeta);
        Player player = (Player)e.getWhoClicked();
        if(e.getInventory().getName().equalsIgnoreCase("§9Choose Your Kit")) {
            e.setCancelled(true);
        }
        if(e.getSlot() == 1 && e.getInventory().getName().equalsIgnoreCase("§9Choose Your Kit")) {
            player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
            player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
            player.getInventory().addItem(pvp);
            for(int i = 0; i < 35; i++) {
                player.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
            }
            player.sendMessage("§eYou have chosen the §aPvP §ekit.");
            player.closeInventory();
        }
        if(e.getSlot() == 2 && e.getInventory().getName().equalsIgnoreCase("§9Choose Your Kit")) {
            player.getInventory().setHelmet(archerhelmet);
            player.getInventory().setChestplate(archerchestplate);
            player.getInventory().setLeggings(archerleggings);
            player.getInventory().setBoots(archerboots);
            player.getInventory().addItem(archersword);
            player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 3));
            player.getInventory().addItem(archerbow);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
            for(int i = 0; i < 31; i++) {
                player.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
            }
            player.sendMessage("§eYou have chosen the §dArcher §ekit.");
            player.closeInventory();
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&6Kits")));
        player.performCommand("kits");
    }

}