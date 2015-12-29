package com.sbb.listeners.player;

import com.sbb.Sbb;
import com.sbb.listeners.SBBListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract extends SBBListener {

    public PlayerInteract(Sbb pl) {
        super(pl);
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Action action = e.getAction();
        if (action == Action.RIGHT_CLICK_BLOCK) {
            e.setCancelled(false);
        }
    }
}
