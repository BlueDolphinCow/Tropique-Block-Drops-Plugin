package me.sevenwone.tropiqueblockdrops.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.getName().equals("7w1")) {
            player.sendMessage(ChatColor.GREEN + "This server is using your plugin TropiqueBlockDrops.");
        }
    }

}
