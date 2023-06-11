package com.forest.unongforest.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class EnchantGui {
    public static Inventory getInventory() {
        Inventory ret = Bukkit.createInventory(null, 27);
        return ret;
    }
}
