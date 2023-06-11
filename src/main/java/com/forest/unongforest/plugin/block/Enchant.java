package com.forest.unongforest.plugin.block;

import com.forest.unongforest.gui.enchant.EnchantGui;
import com.forest.unongforest.plugin.Method;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Enchant implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (b.getType().equals(Material.ENCHANTING_TABLE)) {
                p.openInventory(EnchantGui.getInventory());
            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        Inventory Inv = e.getClickedInventory();
        Player p = (Player) e.getWhoClicked();
        if(p.getOpenInventory().equals(EnchantGui.getInventory())){
            e.setCancelled(true);
            if (Method.canEnchantable(e.getClickedInventory().getItem(e.getSlot()))){
            }
        }
    }
}