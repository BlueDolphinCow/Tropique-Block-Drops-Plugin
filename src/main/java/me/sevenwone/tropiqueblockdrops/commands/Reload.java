package me.sevenwone.tropiqueblockdrops.commands;

import me.sevenwone.tropiqueblockdrops.TropiqueBlockDrops;
import me.sevenwone.tropiqueblockdrops.events.BlockBreak;
import me.sevenwone.tropiqueblockdrops.util.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Reload implements CommandExecutor {
    private Plugin plugin = TropiqueBlockDrops.getPlugin(TropiqueBlockDrops.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("tropiqueblockdrops.reload")) {
            plugin.reloadConfig();
            BlockBreak.reloadConfig();

            Logger.log("Config reloaded.");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&d" + TropiqueBlockDrops.getPlugin(TropiqueBlockDrops.class).getName() + "&7]&r Config reloaded."));
        }
        return true;
    }
}
