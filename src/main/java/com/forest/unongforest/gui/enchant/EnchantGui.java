package com.forest.unongforest.gui.enchant;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EnchantGui {
    public static Inventory getInventory() {
        Inventory EI = Bukkit.createInventory(null, 27, "마법부여");
        for (int i = 0; i <= 44; i++) {
            if (i != 22) {
                EI.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
        }
        return EI;
    }
}
