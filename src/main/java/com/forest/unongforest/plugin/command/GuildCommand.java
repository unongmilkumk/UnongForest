package com.forest.unongforest.plugin.command;

import com.forest.unongforest.plugin.guild.Guild;
import com.forest.unongforest.plugin.guild.GuildList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length != 0){
            switch (args[0]) {
                case "make" -> GuildList.addGuild(new Guild(p));
                case "go" -> {
                    if (GuildList.getGuild(p) != null && GuildList.getGuild(p).hasBeacon()) {
                        p.teleport(GuildList.getGuild(p).getBeacon().add(0.0, 1.0, 0.0));
                    }
                }
            }
        }
        return false;
    }
}
