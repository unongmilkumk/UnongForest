package com.forest.unongforest;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hello World");
    }

    @Override
    public void onDisable() {
        getLogger().info("Bye World");
    }

    public static Main getInstance() {
        return getPlugin(Main.class);
    }
}
