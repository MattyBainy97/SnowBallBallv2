package com.sbb.handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class PointSB {
    
    private static Scoreboard playerPoints = null;
    private static Objective points = null;
    private static Score c = null;
    private static Score y = null;
    private static Team cy = null;
    private static Team ye = null;
    
    public static void initializeScoreboard(){
        
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        playerPoints = manager.getNewScoreboard();
        points = playerPoints.registerNewObjective("test", "dummy");
        points.setDisplaySlot(DisplaySlot.SIDEBAR);
        points.setDisplayName(ChatColor.AQUA + "SnowBall" + ChatColor.BLUE + "Ball");
        
        cy = playerPoints.registerNewTeam("cyan");
        cy.setPrefix(ChatColor.DARK_AQUA + "");

        ye = playerPoints.registerNewTeam("yellow");
        ye.setPrefix(ChatColor.YELLOW + "");
        
    }
    
    public static void showScoreboard(){
        
        for(Player p : Bukkit.getOnlinePlayers()){
            
            p.setScoreboard(playerPoints);
            c = points.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_AQUA + "CYAN"));
            c.setScore(0);
            y = points.getScore(Bukkit.getOfflinePlayer(ChatColor.YELLOW + "YELLOW"));
            y.setScore(0);
            
        }
        
    }
    
    public static void addCyan(Player player){
        
        cy.addPlayer(player);
        
    }
    
    public static void addYellow(Player player){
        
        ye.addPlayer(player);
        
    }
    
    public static void removeCyan(Player player){
        
        cy.removePlayer(player);
        
    }
    
    public static void removeYellow(Player player){
        
        ye.removePlayer(player);
        
    }
    
    public static void addPoints(int i, String team){
        
        if(team.equals("cyan")){
            
            c = points.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_AQUA + "CYAN"));
            c.setScore(c.getScore() + i);
            
        }else if(team.equals("yellow")){
            
            y = points.getScore(Bukkit.getOfflinePlayer(ChatColor.YELLOW + "YELLOW"));
            y.setScore(y.getScore() + i);
            
        }
        
    }
    
    public static void removePoints(int i, String team){
        
        if(team.equals("cyan")){
            
            c = points.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_AQUA + "CYAN"));
            c.setScore(c.getScore() - i);
            
        }else if(team.equals("yellow")){
            
            y = points.getScore(Bukkit.getOfflinePlayer(ChatColor.YELLOW + "YELLOW"));
            y.setScore(y.getScore() - i);
            
        }
        
    }
    
    public static int getCyanPoints(){
        
        return points.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_AQUA + "CYAN")).getScore();
        
    }
    
    public static int getYellowPoints(){
        
        return points.getScore(Bukkit.getOfflinePlayer(ChatColor.YELLOW + "YELLOW")).getScore();
        
    }
    
    public static void unregisterTeams(){
        
        cy.unregister();
        ye.unregister();
        
    }
    
}