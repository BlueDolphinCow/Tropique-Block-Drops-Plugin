package me.sevenwone.tropiqueblockdrops.util;

import me.sevenwone.tropiqueblockdrops.TropiqueBlockDrops;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {

    public static void log(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&7[&d" + TropiqueBlockDrops.getPlugin(TropiqueBlockDrops.class).getName() + "&7]&r " + msg);
        /*if (!Config.COLOR_LOGS.getBoolean()) {
            msg = ChatColor.stripColor(msg);
        }*/
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    /*public static void debug(String msg) {
        if (Config.DEBUG_MODE.getBoolean()) {
            log("&7[&eDEBUG&7]&r " + msg);
        }
    }*/

}
