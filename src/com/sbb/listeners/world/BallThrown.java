package com.sbb.listeners.world;

import com.sbb.Sbb;
import com.sbb.listeners.SBBListener;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class BallThrown extends SBBListener{
    
    public BallThrown(Sbb pl){
        
        super(pl);
        
    }
    
    @EventHandler
    public void onProjectileThrownEvent(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof Snowball) {
            Player t = (Player) event.getEntity().getShooter();
            t.getInventory().setHelmet(null);
        }
    }
    
}
