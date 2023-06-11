package com.forest.unongforest.gui;

        import org.bukkit.Bukkit;
        import org.bukkit.Material;
        import org.bukkit.inventory.Inventory;
        import org.bukkit.inventory.ItemStack;

public class ResurrectionGui {

    public static Inventory getInventory() {
        Inventory ret = Bukkit.createInventory(null, 27, "부활");
        for (int i = 0; i <= 26; i++) {
            ret.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        return ret;
    }
}
