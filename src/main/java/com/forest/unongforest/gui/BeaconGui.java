package com.forest.unongforest.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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
        ret.setItem(9, new ItemStack(Material.PLAYER_HEAD));
        ret.setItem(11, new ItemStack(Material.TOTEM_OF_UNDYING));
        ret.setItem(13, new ItemStack(Material.EXPERIENCE_BOTTLE));
        ret.setItem(15, new ItemStack(Material.BUNDLE));
        ret.setItem(17, new ItemStack(Material.ELYTRA));
        return ret;
    }

    @EventHandler
    public void click(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Inventory ret = BeaconGui.getInventory();
        int slot = e.getSlot();
        if (e.getClickedInventory().equals(ret)) {
            e.setCancelled(true);
            if (slot == 9){
                p.sendMessage("소환");
            } else if (slot == 11) {
                p.sendMessage("부활");
            } else if (slot == 13) {
                p.sendMessage("교환");
            } else if (slot == 15) {
                p.sendMessage("선물");
            } else if (slot == 18) {
                p.sendMessage("정찰");
            }
        }
    }
}
