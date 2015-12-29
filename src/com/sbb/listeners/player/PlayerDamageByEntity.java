package com.sbb.listeners.player;

import com.sbb.Sbb;
import com.sbb.handlers.Database;
import com.sbb.handlers.SBBItem;
import com.sbb.handlers.SBBTeam;
import com.sbb.listeners.SBBListener;
import com.sbb.utils.ChatUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDamageByEntity extends SBBListener {

    public static Player playerHit;
    
    public PlayerDamageByEntity(Sbb pl) {
        super(pl);
    }

    @EventHandler
    public void onPlayerDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damaged = event.getEntity();
        Entity damageEntity = event.getDamager();

        if (damaged instanceof Player) {

            if (damageEntity instanceof Player) {
                Player hitter = (Player) damageEntity;
                Player gothit = (Player) damaged;

                gothit.getInventory().getChestplate().setDurability((short) 0);

                if (SBBTeam.isInCyan(hitter) && SBBTeam.isInYellow(gothit) && gothit.getInventory().contains(new ItemStack(Material.SNOW_BALL))) {
                    ChatUtilities.broadcast(ChatColor.DARK_AQUA + hitter.getName() + ChatColor.GOLD + " stole the ball from " + ChatColor.YELLOW + gothit.getName());
                    gothit.getInventory().clear();
                    gothit.getInventory().setHelmet(null);
                    hitter.getInventory().setHelmet(SBBItem.lhelm);
                    hitter.getInventory().addItem(new ItemStack(Material.SNOW_BALL));
                    gothit.setHealth(20.0);
                    
                    Database.openConnection();
                    Database.updateSbbTable(hitter, "steals", Database.getSbb(hitter, "steals") + 1);
                    Database.updateSbbTable(hitter, "points", Database.getSbb(hitter, "points") + 1);
                    Database.closeConnection();
                } else if (SBBTeam.isInCyan(hitter) && SBBTeam.isInCyan(gothit)) {
                    event.setCancelled(true);
                } else if (SBBTeam.isInYellow(hitter) && SBBTeam.isInYellow(gothit)) {
                    event.setCancelled(true);
                } else if (SBBTeam.isInYellow(hitter) && SBBTeam.isInCyan(gothit) && gothit.getInventory().contains(new ItemStack(Material.SNOW_BALL))) {
                    ChatUtilities.broadcast(ChatColor.YELLOW + hitter.getName() + ChatColor.GOLD + " stole the ball from " + ChatColor.DARK_AQUA + gothit.getName());
                    gothit.getInventory().clear();
                    gothit.getInventory().setHelmet(null);
                    hitter.getInventory().setHelmet(SBBItem.lhelm);
                    hitter.getInventory().addItem(new ItemStack(Material.SNOW_BALL));
                    gothit.setHealth(20.0);
                    
                    Database.openConnection();
                    Database.updateSbbTable(hitter, "steals", Database.getSbb(hitter, "steals") + 1);
                    Database.updateSbbTable(hitter, "points", Database.getSbb(hitter, "points") + 1);
                    Database.closeConnection();
                }
                gothit.setHealth(20.0);
            }

            if (damageEntity instanceof Snowball) {
                Snowball snowball = (Snowball) damageEntity;
                LivingEntity entityThrower = (LivingEntity)snowball.getShooter();
                if (entityThrower instanceof Player) {
                    Player playerThrower = (Player) entityThrower;
                    playerHit = (Player) damaged;

                    playerHit.getInventory().getChestplate().setDurability((short) 0);

                    playerThrower.getInventory().setHelmet(null);
                    playerThrower.getInventory().clear();
                    playerHit.getInventory().setHelmet(SBBItem.lhelm);
                    playerHit.getInventory().addItem(new ItemStack(Material.SNOW_BALL));

                    if (SBBTeam.isInCyan(playerThrower) && SBBTeam.isInYellow(playerHit)) {
                        ChatUtilities.broadcast(ChatColor.DARK_AQUA + playerThrower.getName() + ChatColor.GOLD + " passed the ball to " + ChatColor.YELLOW + playerHit.getName());
                    } else if (SBBTeam.isInCyan(playerThrower) && SBBTeam.isInCyan(playerHit)) {
                        ChatUtilities.broadcast(ChatColor.DARK_AQUA + playerThrower.getName() + ChatColor.GOLD + " passed the ball to " + ChatColor.DARK_AQUA + playerHit.getName());
                    } else if (SBBTeam.isInYellow(playerThrower) && SBBTeam.isInYellow(playerHit)) {
                        ChatUtilities.broadcast(ChatColor.YELLOW + playerThrower.getName() + ChatColor.GOLD + " passed the ball to " + ChatColor.YELLOW + playerHit.getName());
                    } else if (SBBTeam.isInYellow(playerThrower) && SBBTeam.isInCyan(playerHit)) {
                        ChatUtilities.broadcast(ChatColor.YELLOW + playerThrower.getName() + ChatColor.GOLD + " passed the ball to " + ChatColor.DARK_AQUA + playerHit.getName());
                    }

                    Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(Sbb.plugin, new Runnable() {
                        @Override
                        public void run() {
                            playerHit = null;
                        }
                    }, 5L);
                }
            }
        }
    }
}
