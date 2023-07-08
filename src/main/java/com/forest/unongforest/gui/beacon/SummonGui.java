package com.forest.unongforest.gui.beacon;

import com.forest.unongforest.plugin.guild.Guild;
import com.forest.unongforest.plugin.guild.GuildList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SummonGui implements Listener {

    public static Inventory getInventory() {
        Inventory SUI = Bukkit.createInventory(null, 45, "소환");
        for (int i = 0; i <= 44; i++) {
            ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            if (i == 13) {
                item = new ItemStack(Material.AIR);
            } else if (i == 31) {
                item = new ItemStack(Material.LIME_WOOL);
            }
            SUI.setItem(i, item);
        }
        return SUI;
    }

    @EventHandler
    public void OnInvClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        int slot = e.getSlot();
        if (p.getOpenInventory().getTitle().equals("소환")){
            e.setCancelled(true);
            if (slot == 31){
                for(int i = 0; i < 36; i++) {
                    if(Objects.requireNonNull(p.getInventory().getItem(i)).equals(new ItemStack(Material.DIAMOND, 64))) {
                        List<Player> PlayerList = (List<Player>) ((ArrayList<?>) Bukkit.getOnlinePlayers()).clone();
                        for (Player player : PlayerList) {
                            if (GuildList.getGuild(player) == null) {
                                GuildList.getGuild(p).addMember(player);
                            }
                        }
                    }
                }
            }
        }
    }
}
