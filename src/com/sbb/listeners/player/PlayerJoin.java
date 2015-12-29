package com.sbb.listeners.player;

import com.sbb.Sbb;
import com.sbb.handlers.Database;
import com.sbb.handlers.Game;
import com.sbb.handlers.PointSB;
import com.sbb.handlers.SBBItem;
import com.sbb.handlers.SBBTeam;
import com.sbb.listeners.SBBListener;
import com.sbb.utils.LocationUtilities;
import java.lang.reflect.Field;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoin extends SBBListener {

    public PlayerJoin(Sbb pl) {
        
        super(pl);
        
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        
        Database.openConnection();
        
        try{
            
            if(Database.playerTableContainsPlayer(e.getPlayer())){
                
                Database.updateLastLogin(e.getPlayer());
                
            }else{
                
                Database.addPlayerToPlayerTable(e.getPlayer());
                
            }
            
            if(!Database.sbbTableContainsPlayer(e.getPlayer())){
                
                Database.addPlayerToSbbTable(e.getPlayer());
                
            }
            
        }catch(Exception ex){
            
            ex.printStackTrace();
            
        }finally{
            
            Database.closeConnection();
            
        }
        
        e.setJoinMessage("");
        final Player p = e.getPlayer();
        p.setHealth(20.0);
        p.setExp(0);
        p.removePotionEffect(PotionEffectType.INVISIBILITY);
        p.setGameMode(GameMode.ADVENTURE);
        p.getInventory().clear();
        p.getInventory().setHelmet(null);
        Game.setCanStart(Bukkit.getOnlinePlayers().size() >= 2);
        
        if (SBBTeam.cyan.size() <= SBBTeam.yellow.size()) {
            
            PointSB.addCyan(p);
            SBBTeam.addCyan(p);
            p.getInventory().clear();
            p.getInventory().setChestplate(SBBItem.cylchest);
            
        } else {
            
            PointSB.addYellow(p);
            SBBTeam.addYellow(p);
            p.getInventory().clear();
            p.getInventory().setChestplate(SBBItem.yellchest);
            
        }
        
        CraftPlayer craftplayer = (CraftPlayer) p;
        
        PlayerConnection connection = craftplayer.getHandle().playerConnection;
        IChatBaseComponent header = ChatSerializer.a("{\"text\": \"   §bSnowBall§9Ball §cv2   \"}");
        IChatBaseComponent footer = ChatSerializer.a("{\"text\": \"   §4Development Test   \"}");
        PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();

        try {
            Field headerField = packet.getClass().getDeclaredField("a");
            headerField.setAccessible(true);
            headerField.set(packet, header);
            headerField.setAccessible(!headerField.isAccessible());

            Field footerField = packet.getClass().getDeclaredField("b");
            footerField.setAccessible(true);
            footerField.set(packet, footer);
            footerField.setAccessible(!footerField.isAccessible());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        LocationUtilities.teleportToLobby(p);
        
        connection.sendPacket(packet);
        
    }
    
}
