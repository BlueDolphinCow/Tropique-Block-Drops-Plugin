package me.sevenwone.tropiqueblockdrops.util;

import me.sevenwone.tropiqueblockdrops.TropiqueBlockDrops;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {

    public static void log(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&7[&d" + TropiqueBlockDrops.getPlugin(TropiqueBlockDrops.class).getName() + "&7]&r " + msg);
        Bukkit.getConsoleSender().sendMessage(msg);
    }
}
