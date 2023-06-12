package com.forest.unongforest.gui.beacon;

import com.forest.unongforest.plugin.Method;
import com.forest.unongforest.plugin.guild.Guild;
import com.forest.unongforest.plugin.guild.GuildList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class BeaconGui implements Listener {
    public static Inventory getInventory() {
        Inventory BI = Bukkit.createInventory(null, 27, "신호기");
        for (int i = 0; i <= 26; i++) {
            BI.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("구성원 : 1");
        lore1.add("소환비용 : 다이아몬드 X 64개");
        ArrayList<String> lore2 = new ArrayList<>();
        ArrayList<String> lore3 = new ArrayList<>();
        ArrayList<String> lore4 = new ArrayList<>();
        BI.setItem(10, Method.makeItem(Material.PLAYER_HEAD, "소환", lore1));
        BI.setItem(12, Method.makeItem(Material.TOTEM_OF_UNDYING, "부활", lore2));
        BI.setItem(14, Method.makeItem(Material.EXPERIENCE_BOTTLE, "상점", lore3));
        BI.setItem(16, Method.makeItem(Material.ELYTRA, "정찰용 폭죽", lore4));
        return BI;
    }

    @EventHandler
    public void open(InventoryOpenEvent e){
        Player p = (Player) e.getPlayer();
        Inventory BI = BeaconGui.getInventory();
        Guild g = GuildList.getGuild(p);
        if (e.getInventory().equals(BI)) {
            ArrayList<String> lore1 = new ArrayList<>();
            lore1.add("구성원 : " + g.getMembers());
            lore1.add("소환비용 : 다이아몬드X" + g.getMembers().size()*64 + "개");
            BI.setItem(10, Method.makeItem(Material.PLAYER_HEAD, "소환", lore1));
        }
    }

    @EventHandler
    public void click(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Inventory BI = BeaconGui.getInventory();
        int slot = e.getSlot();
        if (Objects.requireNonNull(e.getClickedInventory()).equals(BI)) {
            e.setCancelled(true);
            if (slot == 10){
                p.openInventory(SummonGui.getInventory());
            } else if (slot == 12) {
                p.openInventory(ResurrectionGui.getInventory());
            } else if (slot == 14) {
                p.openInventory(StoreGui.getInventory());
            } else if (slot == 16) {
                if (p.getInventory().getChestplate() == null && p.getInventory().getItem(0) == null) {
                    p.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
                    p.getInventory().setItem(0, new ItemStack(Material.ELYTRA));
                }
                if (p.getInventory().getChestplate() == null) {
                    p.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
                }
            } else {
                e.setCancelled(true);
            }
        }
    }
}