package com.forest.unongforest;

import com.forest.unongforest.gui.BeaconGui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Beacon implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (e.getClickedBlock().getType().equals(Material.BEACON)) {
                p.openInventory(BeaconGui.getInventory());

            }
        }
    }
}
