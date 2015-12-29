package com.sbb.utils;

import com.sbb.GameState;
import com.sbb.GameState;
import com.sbb.handlers.Database;
import com.sbb.handlers.SBBTeam;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import static org.bukkit.ChatColor.*;
import org.bukkit.entity.Player;

public class ChatUtilities {
    
    public static void broadcast(String msg){
        for(Player player : Bukkit.getOnlinePlayers()){
            player.sendMessage(starter() + msg);
        }
    }
    
    public static void onePlayer(String msg, Player player){
        
        player.sendMessage(starter() + msg);
        
    }
    
    public static void chat(String msg, Player player){
        
        if(GameState.isState(GameState.IN_GAME)){
            if (SBBTeam.isInCyan(player)){
                Bukkit.broadcastMessage(DARK_AQUA + player.getDisplayName() + ChatColor.GRAY + " » " + WHITE + msg);
            } else if (SBBTeam.isInYellow(player)) {
                Bukkit.broadcastMessage(YELLOW + player.getDisplayName() + ChatColor.GRAY + " » " + WHITE + msg);
            }
        } else {
            Database.openConnection();
            Bukkit.broadcastMessage(GRAY + "(" + YELLOW + Database.getSbb(player, "points") + GRAY + ") " + WHITE + player.getDisplayName() + ChatColor.GRAY + " » " + WHITE + msg);
            Database.closeConnection();
        }
        
    }
    
    public static void records(Player player){
        
        Database.openConnection();
        
        try{
            
            player.sendMessage("User: " + player.getName());
            player.sendMessage("Points: " + Database.getSbb(player, "points"));
            player.sendMessage("Games: " + Database.getSbb(player, "games"));
            player.sendMessage("Wins: " + Database.getSbb(player, "wins"));
            player.sendMessage("Losses: " + Database.getSbb(player, "losses"));
            player.sendMessage("Scores: " + Database.getSbb(player, "scores"));
            player.sendMessage("Steals: " + Database.getSbb(player, "steals"));
            
        }catch(Exception ex){
            
            ex.printStackTrace();
            
        }finally{
            
            Database.closeConnection();
            
        }
        
    }
    
    private static String starter(){
        
        return GRAY + "[" + AQUA + "SnowBall" + BLUE + "Ball" + GRAY + "] " + GOLD;
        
    }
}
