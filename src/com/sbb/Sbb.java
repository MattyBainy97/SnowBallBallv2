package com.sbb;

import java.sql.Connection;
import java.sql.SQLException;
import org.bukkit.plugin.java.JavaPlugin;
import com.sbb.handlers.Database;
import com.sbb.handlers.Game;
import com.sbb.handlers.PointSB;
import com.sbb.handlers.SBBItem;
import com.sbb.listeners.world.BallThrown;
import com.sbb.listeners.inventory.ClickSlot;
import com.sbb.listeners.player.OnChat;
import com.sbb.listeners.player.PickUpBall;
import com.sbb.listeners.player.PlayerDamageByEntity;
import com.sbb.listeners.player.PlayerDrop;
import com.sbb.listeners.player.PlayerInteract;
import com.sbb.listeners.player.PlayerInteractEntity;
import com.sbb.listeners.player.PlayerJoin;
import com.sbb.listeners.player.PlayerMove;
import com.sbb.listeners.player.PlayerQuit;
import com.sbb.listeners.world.BallHitGround;
import com.sbb.threads.StartCountdown;
import com.sbb.utils.ChatUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Sbb extends JavaPlugin{
    
    public static Plugin plugin;
    
    @Override
    public void onEnable(){
        
        plugin = this;
        
        for(Player p : Bukkit.getOnlinePlayers()){
            
            p.kickPlayer(ChatColor.GREEN + "Reloading. Rejoin.");
            
        }
        
        for (World w : Bukkit.getServer().getWorlds()) {
            
            w.setTime(0);
            w.setStorm(false);
            w.setWeatherDuration(9999999);
            for (Entity e : w.getEntities()) {
                e.remove();
            }
            
        }
        
        GameState.setState(GameState.IN_LOBBY);
        Game.setCanStart(false);
        new Thread(new StartCountdown()).start();
        SBBItem.setMetas();
        registerListeners();
        PointSB.initializeScoreboard();
        
    }
    
    @Override
    public void onDisable(){
        
        plugin = null;
        
        PointSB.unregisterTeams();
        
        try{
            
            Connection c = Database.getConnection();
            if(c != null && c.isClosed()){
                
                c.close();
                
            }
            
        }catch(SQLException e){
            
            e.printStackTrace();
            
        }
        
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        
        if (commandLabel.equalsIgnoreCase("start")) {
            
            Player p = (Player) sender;
            
            if (args.length == 0) {
            
                Game.start();
                
            }else{
                
                ChatUtilities.onePlayer("Wrong use of this command!", p);
                
            }
            
        }
        
        if (commandLabel.equalsIgnoreCase("records")) {
            
            Player p = (Player) sender;
            
            if (args.length == 0) {
            
                ChatUtilities.records((Player) sender);
                
            }else{
                
                ChatUtilities.onePlayer("Wrong use of this command!", p);
                
            }
            
        }
        
        return false;
        
    }
    
    public void registerListeners(){
        
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new PlayerQuit(this), this);
        pm.registerEvents(new PlayerDamageByEntity(this), this);
        pm.registerEvents(new PlayerInteract(this), this);
        pm.registerEvents(new PlayerMove(this), this);
        pm.registerEvents(new PlayerInteractEntity(this), this);
        pm.registerEvents(new PlayerDrop(this), this);
        pm.registerEvents(new ClickSlot(this), this);
        pm.registerEvents(new BallThrown(this), this);
        pm.registerEvents(new PickUpBall(this), this);
        pm.registerEvents(new BallHitGround(this), this);
        pm.registerEvents(new OnChat(this), this);
        
    }
    
}
