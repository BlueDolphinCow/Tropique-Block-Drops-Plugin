package me.sevenwone.tropiqueblockdrops;

import me.sevenwone.tropiqueblockdrops.events.BlockBreak;
import me.sevenwone.tropiqueblockdrops.util.Config;
import me.sevenwone.tropiqueblockdrops.util.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class TropiqueBlockDrops extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger.log("&aPlugin starting up.");
        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        // Event setup
        int previousIndex = 0;
        int previousIndexTwo = 0;
        List<String> customDrops = Config.checkList("custom-drop-values");
        String[] currentDrops = new String[9999];
        for (String customDrop : customDrops) {
            for (int aIndex = 0; aIndex < Integer.parseInt(customDrop.split(";")[1]); aIndex++) {
                currentDrops[aIndex + previousIndex] = customDrop.split(";")[0];
                previousIndexTwo = aIndex;
            }
            previousIndex = previousIndexTwo + 1;
        }
        Config.setCurrentDrops(currentDrops);
        // Events
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
    }

    @Override
    public void onDisable() {
        Logger.log("&cPlugin shutting down.");
    }
}
