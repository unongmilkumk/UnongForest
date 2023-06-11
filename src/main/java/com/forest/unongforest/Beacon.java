package com.forest.unongforest;

import com.forest.unongforest.gui.BeaconGui;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Beacon implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (e.getClickedBlock().getType().equals(Material.BEACON)) {
                p.openInventory(BeaconGui.getInventory());
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if (b.getLocation().getBlockY() <= 64){
            p.sendMessage("신호기가 설치되었습니다");
        } else {
            p.sendMessage("해수면 아래에 신호기를 설치해 주세요");
        }
    }
}
