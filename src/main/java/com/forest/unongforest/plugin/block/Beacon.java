package com.forest.unongforest.plugin.block;

import com.forest.unongforest.gui.beacon.BeaconGui;
import com.forest.unongforest.plugin.guild.Guild;
import com.forest.unongforest.plugin.guild.GuildList;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class Beacon implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (Objects.requireNonNull(b).getType().equals(Material.BEACON)) {
                p.openInventory(BeaconGui.getInventory());
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        Guild g = GuildList.getGuild(p);
        if (b.getType().equals(Material.BEACON)) {
            if (g == null) {
                e.setCancelled(true);
                return;
            }
            if (g.hasBeacon()) {
                e.setCancelled(true);
                return;
            }
            if (b.getLocation().getBlockY() <= 64) {
                p.sendMessage("신호기가 설치되었습니다");
                g.setBeacon(b.getLocation());
            } else {
                p.sendMessage("해수면 아래에 신호기를 설치해 주세요");
                e.setCancelled(true);
            }
        }
    }
}
