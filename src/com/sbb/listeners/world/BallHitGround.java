package com.sbb.listeners.world;

import com.sbb.Sbb;
import com.sbb.handlers.SBBTeam;
import com.sbb.listeners.SBBListener;
import com.sbb.listeners.player.PlayerDamageByEntity;
import com.sbb.utils.ChatUtilities;
import com.sbb.utils.LocationUtilities;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BlockIterator;

public class BallHitGround extends SBBListener{
    
    public BallHitGround(Sbb pl){
        
        super(pl);
        
    }
    
    @EventHandler
    public void onHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball) {

            BlockIterator iterator = new BlockIterator(event.getEntity().getWorld(), event.getEntity().getLocation().toVector(), event.getEntity().getVelocity().normalize(), 0.0D, 4);
            Block hitBlock = null;
            while (iterator.hasNext()) {
                hitBlock = iterator.next();



                if (hitBlock.getTypeId() != 0) {
                    break;
                }
            }

            if (hitBlock.getType() != Material.AIR && PlayerDamageByEntity.playerHit == null && SBBTeam.isInCyan((Player) event.getEntity().getShooter())) {
                if (LocationUtilities.isInside(hitBlock.getLocation(), new Location(hitBlock.getWorld(), -1181, 85, 341), new Location(hitBlock.getWorld(), -1235, 22, 461))) {
                    ChatUtilities.broadcast(ChatColor.GOLD + "Ball dropped by " + ChatColor.DARK_AQUA + "CYAN");
                    hitBlock.getWorld().dropItem(hitBlock.getLocation(), new ItemStack(Material.SNOW_BALL));
                } else if (!LocationUtilities.isInside(hitBlock.getLocation(), new Location(hitBlock.getWorld(), -1181, 85, 341), new Location(hitBlock.getWorld(), -1235, 22, 461))) {
                    ChatUtilities.broadcast(ChatColor.GOLD + "Ball returned to centre");
                    LocationUtilities.dropBall();
                }

            } else if (hitBlock.getType() != Material.AIR && PlayerDamageByEntity.playerHit == null && SBBTeam.isInYellow((Player) event.getEntity().getShooter())) {
                if (LocationUtilities.isInside(hitBlock.getLocation(), new Location(hitBlock.getWorld(), -1181, 85, 341), new Location(hitBlock.getWorld(), -1235, 22, 461))) {
                    ChatUtilities.broadcast(ChatColor.GOLD + "Ball dropped by " + ChatColor.YELLOW + "YELLOW");
                    hitBlock.getWorld().dropItem(hitBlock.getLocation(), new ItemStack(Material.SNOW_BALL));
                } else if (!LocationUtilities.isInside(hitBlock.getLocation(), new Location(hitBlock.getWorld(), -1181, 85, 341), new Location(hitBlock.getWorld(), -1235, 22, 461))) {
                    ChatUtilities.broadcast(ChatColor.GOLD + "Ball returned to centre");
                    LocationUtilities.dropBall();
                }
            }
        }
    }
    
}
