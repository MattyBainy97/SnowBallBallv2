package com.sbb.handlers;

import com.sbb.GameState;
import com.sbb.Sbb;
import com.sbb.threads.GameTimer;
import com.sbb.threads.ReloadTimer;
import com.sbb.utils.ChatUtilities;
import com.sbb.utils.LocationUtilities;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Game {
    
    private static boolean canStart = false;
    private static boolean hasStarted = false;
    
    public static void start(){
        
        Sbb.plugin.getServer().getScheduler().scheduleSyncDelayedTask(Sbb.plugin, new Runnable() {
            @Override
            public void run() {
                
                new Thread(new GameTimer()).start();
                GameState.setState(GameState.IN_GAME);
        
                for (Player player : Bukkit.getOnlinePlayers()) {
                    
                    player.setHealth(20.0);
                    player.setFoodLevel(40);
                    PointSB.showScoreboard();
                    player.setGameMode(GameMode.ADVENTURE);
                    
                    Database.openConnection();
                    Database.updateSbbTable(player, "games", Database.getSbb(player, "games") + 1);
                    Database.closeConnection();
                    
                }

                ChatUtilities.broadcast(ChatColor.GOLD + "LET THE GAME COMMENCE!");
                ChatUtilities.broadcast(ChatColor.GOLD + "5 minutes left!");

                LocationUtilities.dropBall();
                LocationUtilities.teleportToGame();
            }
        }, 5L);
        
        hasStarted = true;
                
    }
    
    public static void stop() {
        
        if(PointSB.getCyanPoints() > PointSB.getYellowPoints()){
            
            ChatUtilities.broadcast(ChatColor.DARK_AQUA + "CYAN " + ChatColor.GOLD + " Team Win!");
            ChatUtilities.broadcast(ChatColor.GOLD + "All players on " + ChatColor.DARK_AQUA + "CYAN" + ChatColor.GOLD + " gain " + ChatColor.GREEN + "20" + ChatColor.GOLD + " points");
            
            for(UUID uuid : SBBTeam.cyan){
                
                Player p = Bukkit.getPlayer(uuid);
                Database.openConnection();
                Database.updateSbbTable(p, "points", Database.getSbb(p, "points") + 20);
                Database.updateSbbTable(p, "wins", Database.getSbb(p, "wins") + 1);
                Database.closeConnection();
                
            }
            
            for(UUID uuid : SBBTeam.yellow){
                
                Player p = Bukkit.getPlayer(uuid);
                Database.openConnection();
                Database.updateSbbTable(p, "losses", Database.getSbb(p, "losses") + 1);
                Database.closeConnection();
                
            }
            
        }else if(PointSB.getYellowPoints() > PointSB.getCyanPoints()){
            
            ChatUtilities.broadcast(ChatColor.YELLOW + "YELLOW " + ChatColor.GOLD + " Team Win!");
            ChatUtilities.broadcast(ChatColor.GOLD + "All players on " + ChatColor.YELLOW + "YELLOW" + ChatColor.GOLD + " gain " + ChatColor.GREEN + "20" + ChatColor.GOLD + " points");
            
            for(UUID uuid : SBBTeam.yellow){
                
                Player p = Bukkit.getPlayer(uuid);
                Database.openConnection();
                Database.updateSbbTable(p, "points", Database.getSbb(p, "points") + 20);
                Database.updateSbbTable(p, "wins", Database.getSbb(p, "wins") + 1);
                Database.closeConnection();
                
            }
            
            for(UUID uuid : SBBTeam.cyan){
                
                Player p = Bukkit.getPlayer(uuid);
                Database.openConnection();
                Database.updateSbbTable(p, "losses", Database.getSbb(p, "losses") + 1);
                Database.closeConnection();
                
            }
            
        }else{
            
            ChatUtilities.broadcast("Teams have drawn!");
            ChatUtilities.broadcast(ChatColor.GOLD + "All players gain " + ChatColor.GREEN + "20" + ChatColor.GOLD + " points");
            
            for(UUID uuid : SBBTeam.cyan){
                
                Player p = Bukkit.getPlayer(uuid);
                Database.openConnection();
                Database.updateSbbTable(p, "points", Database.getSbb(p, "points") + 20);
                Database.updateSbbTable(p, "wins", Database.getSbb(p, "wins") + 1);
                Database.closeConnection();
                
            }
            
            for(UUID uuid : SBBTeam.yellow){
                
                Player p = Bukkit.getPlayer(uuid);
                Database.openConnection();
                Database.updateSbbTable(p, "points", Database.getSbb(p, "points") + 20);
                Database.updateSbbTable(p, "wins", Database.getSbb(p, "wins") + 1);
                Database.closeConnection();
                
            }
            
        }
        
        new Thread(new ReloadTimer()).start();
        canStart = false;
        hasStarted = false;
        
    }

    public static boolean canStart() {
        
        return canStart;
        
    }

    public static boolean hasStarted() {
        
        return hasStarted;
        
    }

    public static void setCanStart(boolean b) {
        
        canStart = b;
        
    }
    
}
