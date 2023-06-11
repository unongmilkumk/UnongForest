package com.forest.unongforest.guild;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GuildList {
    private static ArrayList<Guild> guilds;
    public static Guild getGuild(Player player) {
        final Guild[] ret = new Guild[1];
        guilds.forEach(guild -> {
            if (guild.containsMember(player)) ret[0] = guild;
        });
        return ret[0];
    }
    public static void addGuild(Guild guild) {
        guilds.add(guild);
    }
}
