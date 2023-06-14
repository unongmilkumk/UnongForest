package com.forest.unongforest.plugin;

import com.forest.unongforest.gui.command.GuildCommand;
import com.forest.unongforest.plugin.block.Beacon;
import com.forest.unongforest.plugin.block.Enchant;
import com.forest.unongforest.gui.beacon.BeaconGui;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hello World");
        getServer().getPluginManager().registerEvents(new BeaconGui(), this);
        getServer().getPluginManager().registerEvents(new Beacon(), this);
        getServer().getPluginManager().registerEvents(new Enchant(), this);
        getCommand("guild").setExecutor(new GuildCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Bye World");
    }

    public static Main getInstance() {
        return getPlugin(Main.class);
    }
}
