package me.staud.apollo.listener;

// Axris Code

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SoupListener implements Listener {

    @EventHandler
    public void onPlayerInteractSoup(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(((Damageable)player).getHealth() != 20.0) {
            int soup = 7;
            if(!(player.isDead() && player.getItemInHand().getType() == Material.MUSHROOM_SOUP && ((((Damageable)player).getHealth() < 19.0)))) {

            }
            if((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
                player.setHealth((((Damageable)player).getHealth() + soup > ((Damageable)player).getMaxHealth()) ? ((Damageable)player).getMaxHealth() : (((Damageable)player).getHealth() + soup));
                player.getItemInHand().setType(Material.BOWL);
                player.updateInventory();
            }
        }
    }

}
