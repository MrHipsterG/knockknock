package eu.starhop.knockknock.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Door;
import org.bukkit.block.data.type.TrapDoor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void OnPlayerLeftClick(PlayerInteractEvent event) {
        Action action = event.getAction();
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        Sound knockSound = Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR;
        float volume = 0.6f;
        float pitch = 1.5f;
        World world;
        BlockData blockData;
        if (block != null) {
            world = event.getClickedBlock().getWorld();
            blockData = block.getBlockData();
        }
        else {
            return;
        }

        if (action.isLeftClick() ) {
            if ((blockData instanceof Door) || (blockData instanceof TrapDoor)) {
                if ((blockData.getMaterial().equals(Material.IRON_DOOR)) || (blockData.getMaterial().equals(Material.IRON_TRAPDOOR))) {
                    knockSound = Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR;
                }
                world.playSound(player.getLocation(), knockSound,volume, pitch);
            }
        }
    }
}
