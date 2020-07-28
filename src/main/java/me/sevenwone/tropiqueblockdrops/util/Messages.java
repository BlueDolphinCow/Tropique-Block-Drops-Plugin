package me.sevenwone.tropiqueblockdrops.util;


import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Messages {
    public static String translateMessage(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    public static String translateMessageHex(String msg) {
        Matcher matcher = Pattern.compile("<#[A-Fa-f0-9]{6}>").matcher(msg);
        int hexCount = 0;
        while (matcher.find()) {
            matcher.region(matcher.end() - 1, msg.length());
            hexCount++;
        }
        int startIndex = 0;
        for (int hexIndex = 0; hexIndex < hexCount; hexIndex++) {
            int msgIndex = msg.indexOf("<#", startIndex);
            String hexCode = msg.substring(msgIndex + 1, msgIndex + 8);
            startIndex = msgIndex + 2;
            msg = msg.replace("<" + hexCode + ">", ChatColor.of(hexCode) + "");
        }
        return msg;
    }
}
