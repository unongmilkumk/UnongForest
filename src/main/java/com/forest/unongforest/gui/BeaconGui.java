package com.forest.unongforest.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BeaconGui implements Listener {
    public static Inventory getInventory() {
        Inventory ret = Bukkit.createInventory(null, 3, "신호기");
        for (int i = 0; i <= 26; i++) {
            ret.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        ret.setItem(12, new ItemStack(Material.));
        return ret;
    }
    @EventHandler
    public void onClick(InventoryClickEvent e) {

    }
}
