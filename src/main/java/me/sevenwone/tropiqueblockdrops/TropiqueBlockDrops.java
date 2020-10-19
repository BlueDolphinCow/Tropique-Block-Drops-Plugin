package me.sevenwone.tropiqueblockdrops;

import me.sevenwone.tropiqueblockdrops.commands.Reload;
import me.sevenwone.tropiqueblockdrops.events.BlockBreak;
import me.sevenwone.tropiqueblockdrops.events.PlayerJoin;
import me.sevenwone.tropiqueblockdrops.util.Logger;
import org.bukkit.plugin.java.JavaPlugin;


public final class TropiqueBlockDrops extends JavaPlugin {

    private static TropiqueBlockDrops instance;

    @Override
    public void onEnable() {
        instance = this;
        Logger.log("&aPlugin starting up.");
        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        // Events
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        // Commands
        getCommand("tropiqueblockdrops").setExecutor(new Reload());
    }

    @Override
    public void onDisable() {
        Logger.log("&cPlugin shutting down.");
    }

    public static TropiqueBlockDrops getInstance() {
        return instance;
    }

}
