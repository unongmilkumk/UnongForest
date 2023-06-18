package com.forest.unongforest.plugin.block;

import com.forest.unongforest.gui.enchant.EnchantGui;
import com.forest.unongforest.plugin.Method;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class Enchant implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (Objects.requireNonNull(b).getType().equals(Material.ENCHANTING_TABLE)) {
                e.setCancelled(true);
                p.openInventory(EnchantGui.getInventory());
            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        Inventory inv = e.getClickedInventory();
        if(inv != null) {
            Player p = (Player) e.getWhoClicked();
            ItemStack i = inv.getItem(13);
            ItemStack ClickItem = e.getClickedInventory().getItem(e.getSlot());
            if (e.getView().getTitle().equals("마법부여") && e.getRawSlot() <= 44 && e.getSlot() != 13) {
                e.setCancelled(true);
                if (i != null && !i.getType().equals(Material.AIR)
                        && Method.canEnchantable(i) && e.getSlot() == 31) {
                    List<Enchantment> ench = new ArrayList<>(Arrays.stream(Enchantment.values()).toList());
                    Collections.shuffle(ench);
                    i.addUnsafeEnchantment(ench.get(0), ench.get(0).getMaxLevel());
                    inv.setItem(13, i);
                }
            }
        }
    }
}