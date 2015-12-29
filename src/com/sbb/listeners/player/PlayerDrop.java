package com.sbb.listeners.player;

import com.sbb.Sbb;
import com.sbb.listeners.SBBListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDrop extends SBBListener{
    
    public PlayerDrop(Sbb pl){
        super(pl);
    }
    
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }
    
}
