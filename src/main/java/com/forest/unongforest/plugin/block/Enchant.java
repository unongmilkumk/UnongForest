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
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Enchant implements Listener {

    int Slot = -1;

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (Objects.requireNonNull(b).getType().equals(Material.ENCHANTING_TABLE)) {
                p.openInventory(EnchantGui.getInventory());
            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        Inventory Inv = e.getClickedInventory();
        Player p = (Player) e.getWhoClicked();
        ItemStack i = Objects.requireNonNull(e.getClickedInventory()).getItem(e.getSlot());
        if(Objects.requireNonNull(p.getOpenInventory().getTopInventory()).equals(EnchantGui.getInventory())){
            e.setCancelled(true);
            if (Method.canEnchantable(i)){
                p.getOpenInventory().setItem(13, Objects.requireNonNull(i).clone());
                Slot = e.getSlot();
            }
        }
    }
}