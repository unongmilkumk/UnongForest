package com.forest.unongforest.plugin.guild;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GuildList {
    public static ArrayList<Guild> guilds = new ArrayList<>();
    public static Guild getGuild(Player player) {
        final Guild[] ret = new Guild[1];
        ret[0] = null;
        guilds.forEach(guild -> {
            if (guild.containsMember(player)) ret[0] = guild;
        });
        return ret[0];
    }
    public static void addGuild(Guild guild) {
        guilds.add(guild);
    }
    public static void removeGuild(Guild guild) {
        guilds.remove(guild);
    }
}
