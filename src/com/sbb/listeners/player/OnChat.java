package com.sbb.listeners.player;

import com.sbb.Sbb;
import com.sbb.listeners.SBBListener;
import com.sbb.utils.ChatUtilities;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;

public class OnChat extends SBBListener{
    
    public OnChat(Sbb pl){
        
        super(pl);
        
    }
    
    @EventHandler
    public void onChatEvent(PlayerChatEvent pc) {
        
        String msg = pc.getMessage();
        pc.setCancelled(true);
        ChatUtilities.chat(msg, pc.getPlayer());
        
    }
    
}
