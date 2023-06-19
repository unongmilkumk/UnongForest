package com.forest.unongforest.gui.beacon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SummonGui {

    public static Inventory getInventory() {
        Inventory SUI = Bukkit.createInventory(null, 27, "소환");
        for (int i = 0; i <= 26; i++) {
            if (i == 13) {
                SUI.setItem(i, new ItemStack(Material.AIR));
            } else {
                SUI.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
        }
        return SUI;
    }

    @EventHandler
    public void OnInvClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Inventory BI = BeaconGui.getInventory();
        int slot = e.getSlot();
        if (p.getOpenInventory().getTitle().equals("신호기") && e.getRawSlot() <= 26) {
            e.setCancelled(true);
            if (slot == 10){
                p.openInventory(SummonGui.getInventory());
            } else if (slot == 12) {
                p.openInventory(ResurrectionGui.getInventory());
            } else if (slot == 14) {
                p.openInventory(StoreGui.getInventory());
            } else if (slot == 16) {
                if (p.getInventory().getChestplate() == null && p.getInventory().getItem(0) == null) {
                    p.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
                    p.getInventory().setItem(0, new ItemStack(Material.FIREWORK_ROCKET));
                }
                if (p.getInventory().getChestplate() == null) {
                    p.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
                }
            } else {
                e.setCancelled(true);
            }
        }
    }
}
