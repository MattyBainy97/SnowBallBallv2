package com.sbb.listeners.player;

import com.sbb.GameState;
import com.sbb.Sbb;
import com.sbb.handlers.Game;
import com.sbb.handlers.SBBTeam;
import com.sbb.listeners.SBBListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit extends SBBListener {

    public PlayerQuit(Sbb pl) {
        super(pl);
    }
    
    @EventHandler
    public void onPlayerLeaveEvent(PlayerQuitEvent q) {
        
        Player p = q.getPlayer();
        q.setQuitMessage("");
        
        if (GameState.isState(GameState.IN_LOBBY)) {
            
            SBBTeam.cyan.remove(p.getUniqueId());
            SBBTeam.yellow.remove(p.getUniqueId());
            Game.setCanStart(Bukkit.getOnlinePlayers().size() - 1 >= 2);
            
        }
    }
}
