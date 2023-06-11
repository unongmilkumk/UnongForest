package com.forest.unongforest.plugin;

import com.forest.unongforest.plugin.block.Beacon;
import com.forest.unongforest.plugin.block.Enchant;
import com.forest.unongforest.gui.BeaconGui;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hello World");
        Bukkit.getPluginManager().registerEvents(new BeaconGui(), this);
        Bukkit.getPluginManager().registerEvents(new Beacon(), this);
        Bukkit.getPluginManager().registerEvents(new Enchant(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Bye World");
    }

    public static Main getInstance() {
        return getPlugin(Main.class);
    }
}
