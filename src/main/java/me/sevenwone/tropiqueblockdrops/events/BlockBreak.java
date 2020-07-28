package me.sevenwone.tropiqueblockdrops.events;

import me.sevenwone.tropiqueblockdrops.util.Config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.getMaterial(Config.checkMessage("custom-drop-block"))) {
            Location location = block.getLocation();
            ItemStack itemStack = new ItemStack(Config.getRandomItem(), 1);
            event.setDropItems(false);
            location.getWorld().dropItemNaturally(location,itemStack);
        }
    }

}
