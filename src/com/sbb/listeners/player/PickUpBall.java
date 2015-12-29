package com.sbb.listeners.player;

import com.sbb.Sbb;
import com.sbb.handlers.SBBItem;
import com.sbb.handlers.SBBTeam;
import com.sbb.listeners.SBBListener;
import com.sbb.utils.ChatUtilities;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickUpBall extends SBBListener{
    
    public PickUpBall(Sbb pl){
        
        super(pl);
        
    }
    
    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        if (SBBTeam.isInCyan(event.getPlayer())) {
            ChatUtilities.broadcast(ChatColor.DARK_AQUA + event.getPlayer().getName() + ChatColor.GOLD + " picked up the ball");
            event.getPlayer().getInventory().setHelmet(SBBItem.lhelm);
        } else if (SBBTeam.isInYellow(event.getPlayer())) {
            event.getPlayer().getInventory().setHelmet(SBBItem.lhelm);
            ChatUtilities.broadcast(ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GOLD + " picked up the ball");
        }
    }
    
}
