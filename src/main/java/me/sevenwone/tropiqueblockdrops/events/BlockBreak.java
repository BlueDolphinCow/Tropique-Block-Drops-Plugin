package me.sevenwone.tropiqueblockdrops.events;

import me.sevenwone.tropiqueblockdrops.TropiqueBlockDrops;
import me.sevenwone.tropiqueblockdrops.util.Logger;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class BlockBreak implements Listener {

    private static Plugin plugin = TropiqueBlockDrops.getPlugin(TropiqueBlockDrops.class);
    private static FileConfiguration config = plugin.getConfig();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        String name = block.getType().name();
        if (config.contains("blocks." + name))
            event.setDropItems(false);
            for (int index = 0; index < plugin.getConfig().getStringList("blocks." + name + ".drops").size(); index++) {
                Random random = new Random();
                if (random.nextInt(10000)/100 < Double.parseDouble(config.getStringList("blocks." + name + ".drops").get(index).split(";")[1])) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(config.getStringList("blocks." + name + ".drops").get(index).split(";")[0]), Integer.parseInt(config.getStringList("blocks." + name + ".drops").get(index).split(";")[2])));
                }
            }
    }

    public static void reloadConfig() {
        config = plugin.getConfig();
    }
}
