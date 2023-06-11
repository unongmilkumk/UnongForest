package com.forest.unongforest.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuildGui {

    public static Inventory getInventory() {
        Inventory ret = Bukkit.createInventory(null, 3, "신호기");
        for (int i = 0; i <= 26; i++) {
            ret.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        ret.setItem(10, new ItemStack(Material.PLAYER_HEAD));
        ret.setItem(12, new ItemStack(Material.TOTEM_OF_UNDYING));
        ret.setItem(14, new ItemStack(Material.EXPERIENCE_BOTTLE));
        ret.setItem(16, new ItemStack(Material.ELYTRA));
        return ret;
    }
}
