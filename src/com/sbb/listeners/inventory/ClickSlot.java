package com.sbb.listeners.inventory;

import com.sbb.Sbb;
import com.sbb.listeners.SBBListener;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class ClickSlot extends SBBListener {

    public ClickSlot(Sbb pl) {
        super(pl);
    }

    @EventHandler
    public void onClickSlot(InventoryClickEvent e) {
        if (e.getSlot() == 0) {
            e.setResult(Event.Result.DENY);
            e.setCancelled(true);
        }
        if (e.getSlotType() == InventoryType.SlotType.ARMOR) {
            e.setResult(Event.Result.DENY);
            e.setCancelled(true);
        }
    }
}
