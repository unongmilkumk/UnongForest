package com.forest.unongforest.gui;

import com.forest.unongforest.ItemMaker;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BeaconGui implements Listener {
    public static Inventory getInventory() {
        Inventory ret = Bukkit.createInventory(null, 27, "신호기");
        for (int i = 0; i <= 26; i++) {
            ret.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        ArrayList<String> lore = new ArrayList<>();
        lore.add("1");
        ret.setItem(10, ItemMaker.makeItem(Material.PLAYER_HEAD, "소환", lore));
        ret.setItem(12, new ItemStack(Material.TOTEM_OF_UNDYING));
        ret.setItem(14, new ItemStack(Material.EXPERIENCE_BOTTLE));
        ret.setItem(16, new ItemStack(Material.ELYTRA));
        return ret;
    }

    @EventHandler
    public void click(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Inventory ret = BeaconGui.getInventory();
        int slot = e.getSlot();
        if (e.getClickedInventory().equals(ret)) {
            e.setCancelled(true);
            if (slot == 10){
                p.sendMessage("소환");
            } else if (slot == 12) {
                p.sendMessage("부활");
            } else if (slot == 14) {
                p.sendMessage("교환");
            } else if (slot == 16) {
                p.sendMessage("정찰");
            }
        }
    }
}
