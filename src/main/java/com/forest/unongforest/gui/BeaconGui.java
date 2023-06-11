package com.forest.unongforest.gui;

import com.forest.unongforest.Maker;
import com.forest.unongforest.guild.Guild;
import com.forest.unongforest.guild.GuildList;
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

public class BeaconGui implements Listener {
    public static Inventory getInventory() {
        Inventory ret = Bukkit.createInventory(null, 27, "신호기");
        for (int i = 0; i <= 26; i++) {
            ret.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("구성원 : 1");
        lore1.add("소환비용 : 다이아몬드 X 64개");
        ArrayList<String> lore2 = new ArrayList<>();
        ArrayList<String> lore3 = new ArrayList<>();
        ArrayList<String> lore4 = new ArrayList<>();
        ret.setItem(10, Maker.makeItem(Material.PLAYER_HEAD, "소환", lore1));
        ret.setItem(12, Maker.makeItem(Material.TOTEM_OF_UNDYING, "부활", lore2));
        ret.setItem(14, Maker.makeItem(Material.EXPERIENCE_BOTTLE, "상점", lore3));
        ret.setItem(16, Maker.makeItem(Material.ELYTRA, "정찰용 폭죽", lore4));
        return ret;
    }

    @EventHandler
    public void click(InventoryOpenEvent e){
        Player p = (Player) e.getPlayer();
        Inventory ret = BeaconGui.getInventory();
        Guild g = GuildList.getGuild(p.getPlayer());
        g.getMembers().size();
    }

    @EventHandler
    public void click(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Inventory ret = BeaconGui.getInventory();
        int slot = e.getSlot();
        if (e.getClickedInventory().equals(ret)) {
            e.setCancelled(true);
            if (slot == 10){
                p.sendMessage("소환");
            } else if (slot == 12) {
                p.sendMessage("부활");
            } else if (slot == 14) {
                p.sendMessage("교환");
            } else if (slot == 16) {
                p.sendMessage("정찰");
            }
        }
    }
}
