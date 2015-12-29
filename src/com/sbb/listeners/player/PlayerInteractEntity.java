package com.sbb.listeners.player;

import com.sbb.Sbb;
import com.sbb.listeners.SBBListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntity extends SBBListener {

    public PlayerInteractEntity(Sbb pl) {
        super(pl);
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
        e.setCancelled(true);
    }
}
