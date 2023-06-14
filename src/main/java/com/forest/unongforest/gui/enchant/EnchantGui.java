package com.forest.unongforest.gui.enchant;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EnchantGui {
    public static Inventory getInventory() {
        Inventory EI = Bukkit.createInventory(null, 45, "마법부여");
        for (int i = 0; i <= 44; i++) {
            ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            if (i == 13) {
                item = new ItemStack(Material.AIR);
            } else if (i == 31) {
                item = new ItemStack(Material.LIME_WOOL);
            }
            EI.setItem(i, item);
        }
        return EI;
    }
}
