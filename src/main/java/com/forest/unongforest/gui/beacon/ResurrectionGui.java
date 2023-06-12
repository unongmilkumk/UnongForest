package com.forest.unongforest.gui.beacon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ResurrectionGui {
    public static Inventory getInventory() {
        Inventory RI = Bukkit.createInventory(null, 27, "부활");
        for (int i = 0; i <= 26; i++) {
            RI.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        return RI;
    }
}
