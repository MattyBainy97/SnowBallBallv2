package com.sbb.handlers;

import com.sbb.GameState;
import com.sbb.Sbb;
import com.sbb.utils.ChatUtilities;
import com.sbb.utils.LocationUtilities;
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
                GameState.setState(GameState.IN_GAME);
        
                for (Player player : Bukkit.getOnlinePlayers()) {
                    
                    player.getInventory().setChestplate(null);
                    player.getInventory().setHelmet(null);
                    player.setHealth(20.0);
                    player.setFoodLevel(40);
                    PointSB.showScoreboard();
                    player.setGameMode(GameMode.ADVENTURE);
                    
                    Database.openConnection();
                    Database.updateSbbTable(player, "games", Database.getSbb(player, "games") + 1);
                    Database.closeConnection();
                    
                }

                ChatUtilities.broadcast(ChatColor.GOLD + "LET THE GAME COMMENCE!");

                LocationUtilities.dropBall();
                LocationUtilities.teleportToGame();
            }
        }, 5L);
        
        hasStarted = true;
                
    }
    
    public static void stop() {
        
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
