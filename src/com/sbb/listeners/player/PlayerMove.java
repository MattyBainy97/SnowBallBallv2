package com.sbb.listeners.player;

import com.sbb.GameState;
import com.sbb.Sbb;
import com.sbb.handlers.Database;
import com.sbb.handlers.PointSB;
import com.sbb.handlers.SBBItem;
import com.sbb.handlers.SBBTeam;
import com.sbb.listeners.SBBListener;
import com.sbb.utils.ChatUtilities;
import com.sbb.utils.LocationUtilities;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerMove extends SBBListener {

    public PlayerMove(Sbb pl) {
        super(pl);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent m) {
        
        if(GameState.isState(GameState.IN_GAME)){
            if (!LocationUtilities.isInside(m.getPlayer().getLocation(), new Location(m.getPlayer().getWorld(), -1181, 85, 341), new Location(m.getPlayer().getWorld(), -1235, 22, 461))) {
                if (SBBTeam.isInCyan(m.getPlayer())) {
                    m.getPlayer().teleport(LocationUtilities.spawn);
                    if (m.getPlayer().getInventory().contains(new ItemStack(Material.SNOW_BALL))) {
                        m.getPlayer().getInventory().clear();
                        m.getPlayer().getInventory().setHelmet(null);
                        int random = new Random().nextInt(SBBTeam.yellow.size());
                        Player player = Bukkit.getPlayer(SBBTeam.yellow.get(random));
                        player.getInventory().setHelmet(SBBItem.lhelm);
                        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL));
                        ChatUtilities.broadcast(ChatColor.GOLD + "Ball given to " + ChatColor.YELLOW + player.getName() + ChatColor.GOLD + " because " + ChatColor.DARK_AQUA + "CYAN" + ChatColor.GOLD + " took it off the field");
                    }
                } else if (SBBTeam.isInYellow(m.getPlayer())) {
                    m.getPlayer().teleport(LocationUtilities.spawn13);
                    if (m.getPlayer().getInventory().contains(new ItemStack(Material.SNOW_BALL))) {
                        m.getPlayer().getInventory().clear();
                        m.getPlayer().getInventory().setHelmet(null);
                        int random = new Random().nextInt(SBBTeam.cyan.size());
                        Player player = Bukkit.getPlayer(SBBTeam.cyan.get(random));
                        player.getInventory().setHelmet(SBBItem.lhelm);
                        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL));
                        ChatUtilities.broadcast(ChatColor.GOLD + "Ball given to " + ChatColor.DARK_AQUA + player.getName() + ChatColor.GOLD + " because " + ChatColor.YELLOW + "YELLOW" + ChatColor.GOLD + " took it off the field");
                    }
                }
            }
        }
        
        if (m.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.GOLD_BLOCK && SBBTeam.isInCyan(m.getPlayer()) && m.getPlayer().getInventory().contains(new ItemStack(Material.SNOW_BALL))) {

            PointSB.addPoints(1, "cyan");
            
            Database.openConnection();
            Database.updateSbbTable(m.getPlayer(), "points", Database.getSbb(m.getPlayer(), "points") + 5);
            Database.updateSbbTable(m.getPlayer(), "scores", Database.getSbb(m.getPlayer(), "scores") + 1);
            Database.closeConnection();

            LocationUtilities.teleportToGame();
            
            ChatUtilities.broadcast(ChatColor.DARK_AQUA + m.getPlayer().getName() + ChatColor.GOLD + " SCORED FOR " + ChatColor.DARK_AQUA + "CYAN");
            int random = new Random().nextInt(SBBTeam.yellow.size());
            Player player = Bukkit.getPlayer(SBBTeam.yellow.get(random));
            player.getInventory().setHelmet(SBBItem.lhelm);
            player.getInventory().addItem(new ItemStack(Material.SNOW_BALL));
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p != player) {
                    p.getInventory().clear();
                    p.getInventory().setHelmet(null);
                }
            }

        }
        if (m.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.LAPIS_BLOCK && SBBTeam.isInYellow(m.getPlayer()) && m.getPlayer().getInventory().contains(new ItemStack(Material.SNOW_BALL))) {

            PointSB.addPoints(1, "yellow");
            
            Database.openConnection();
            Database.updateSbbTable(m.getPlayer(), "points", Database.getSbb(m.getPlayer(), "points") + 5);
            Database.updateSbbTable(m.getPlayer(), "scores", Database.getSbb(m.getPlayer(), "scores") + 1);
            Database.closeConnection();

            LocationUtilities.teleportToGame();

            m.getPlayer().getInventory().clear();
            ChatUtilities.broadcast(ChatColor.YELLOW + m.getPlayer().getName() + ChatColor.GOLD + " SCORED FOR " + ChatColor.YELLOW + "YELLOW");
            int random = new Random().nextInt(SBBTeam.cyan.size());
            Player player = Bukkit.getPlayer(SBBTeam.cyan.get(random));
            player.getInventory().setHelmet(SBBItem.lhelm);
            player.getInventory().addItem(new ItemStack(Material.SNOW_BALL));
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p != player) {
                    p.getInventory().clear();
                    p.getInventory().setHelmet(null);
                }
            }

        }

    }
}
