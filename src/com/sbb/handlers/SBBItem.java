package com.sbb.handlers;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class SBBItem {
    
    public static ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET, 1);
    
    public static ItemStack cylchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    
    public static ItemStack yellchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                        
            
    public static void setMetas(){
        
        LeatherArmorMeta lam = (LeatherArmorMeta) lhelm.getItemMeta();
        lam.setColor(Color.fromRGB(255, 0, 0));
        lhelm.setItemMeta(lam);
        
        LeatherArmorMeta cylam = (LeatherArmorMeta) cylchest.getItemMeta();
        cylam.setColor(Color.fromRGB(85, 130, 165));
        cylchest.setItemMeta(cylam);
        
        LeatherArmorMeta yellam = (LeatherArmorMeta) yellchest.getItemMeta();
        yellam.setColor(Color.fromRGB(220, 220, 45));
        yellchest.setItemMeta(yellam);
        
    }
}