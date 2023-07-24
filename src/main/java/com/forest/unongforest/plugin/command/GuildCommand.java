package com.forest.unongforest.plugin.command;

import com.forest.unongforest.plugin.guild.Guild;
import com.forest.unongforest.plugin.guild.GuildList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GuildCommand implements CommandExecutor, TabCompleter {
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

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("make");
        list.add("go");
        return list;
    }
}
