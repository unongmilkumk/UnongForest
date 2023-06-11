package com.forest.unongforest.gui.beacon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SummonGui {

    public static Inventory getInventory() {
        Inventory SUI = Bukkit.createInventory(null, 45, "소환");
        for (int i = 0; i <= 44; i++) {
            SUI.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        return SUI;
    }
}
