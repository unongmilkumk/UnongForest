package com.forest.unongforest.plugin.command;

import com.forest.unongforest.plugin.guild.Guild;
import com.forest.unongforest.plugin.guild.GuildList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(label.equals("guild")) {
            if (args.length != 0){
                switch (args[0]) {
                    case "make" -> GuildList.addGuild(new Guild(p));
                    case "invite" -> {
                        Guild guild = GuildList.getGuild(p);
                        if (guild == null) return false;
                        Player player = null;
                        List<Player> playerList = (List<Player>) ((ArrayList<?>) Bukkit.getOnlinePlayers()).clone();
                        Collections.shuffle(playerList);
                        for (Player player1 : playerList) {
                            if (GuildList.getGuild(player1) == null) {
                                player = player1;
                                break;
                            }
                        }
                        if (player == null) return false;
                        guild.addMember(player);
                    }
                }
            }
        }
        return false;
    }
}
