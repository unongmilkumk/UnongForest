package com.forest.unongforest.gui.enchant;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class EnchantGui {
    public static Inventory getInventory() {
        Inventory EI = Bukkit.createInventory(null, 27, "마법부여");
        return EI;
    }
}
