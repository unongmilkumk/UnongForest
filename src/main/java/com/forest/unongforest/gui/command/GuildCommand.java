package com.forest.unongforest.gui.command;

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
        if(label.equals("guild")) {
            if(args.length == 0){

            } else {
                if(args[0].equals("make")){
                    GuildList.addGuild(new Guild(p));
                }
            }
        }
        return false;
    }
}
