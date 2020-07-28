package me.sevenwone.tropiqueblockdrops.util;

import me.sevenwone.tropiqueblockdrops.TropiqueBlockDrops;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Config {

    static Plugin plugin = TropiqueBlockDrops.getPlugin(TropiqueBlockDrops.class);
    static Random random = new Random();
    static String[] currentDrops = new String[9999];

    /*public static boolean checkPermission(String configValue, Player player) {
        String permission_node;
        switch (configValue) {
            default:
                throw new IllegalStateException("Unexpected value: " + configValue);
        }
        return player.hasPermission(permission_node);
    }*/

    public static String checkMessage(String configValue) {
        return Messages.translateMessageHex(Messages.translateMessage(plugin.getConfig().getString(configValue)).replace("{apostrophe}", "'"));
    }

    public static List<String> checkList(String configValue) {
        return plugin.getConfig().getStringList(configValue);
    }

    public static Material getRandomItem() {
        Material material = Material.getMaterial(currentDrops[random.nextInt(9999)]);
        if (material == null) {
            material = Material.getMaterial(currentDrops[0]);
        }
        return material;
    }

    public static void setCurrentDrops(String[] drops) {
        currentDrops = drops;
    }

}
