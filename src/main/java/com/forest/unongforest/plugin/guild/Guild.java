package com.forest.unongforest.plugin.guild;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Guild {
    private Player leader;
    private ArrayList<Player> members;
    private Location beacon;

    public Guild(Player leader) {
        this.leader = leader;
        this.members = new ArrayList<>();
        this.members.add(leader);
        GuildList.addGuild(this);
    }

    public Player getLeader() {
        return leader;
    }

    public void setLeader(Player leader) {
        this.leader = leader;
    }

    public ArrayList<Player> getMembers() {
        return members;
    }

    public boolean addMember(Player player) {
        return members.add(player);
    }

    public boolean removeMember(Player player) {
        return members.remove(player);
    }

    public boolean containsMember(Player player) {
        return members.contains(player);
    }

    public boolean hasBeacon() {
        return beacon != null;
    }

    public void setBeacon(Location location) {
        beacon = location;
    }

    public Location getBeacon() {
        return beacon;
    }
}