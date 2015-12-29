package com.sbb.handlers;

import java.util.ArrayList;
import java.util.UUID;
import org.bukkit.entity.Player;

public class SBBTeam {

    public static ArrayList<UUID> cyan = new ArrayList<UUID>();
    public static ArrayList<UUID> yellow = new ArrayList<UUID>();

    public static void addCyan(Player p) {
        
        cyan.add(p.getUniqueId());
        
    }
    
    public static void addYellow(Player p) {
        
        yellow.add(p.getUniqueId());
        
    }

    public static void remove(Player p) {
        
        if (isInCyan(p)) {
            
            cyan.remove(p.getUniqueId());
            
        }else if (isInYellow(p)) {
            
            yellow.remove(p.getUniqueId());
            
        }
        
    }

    public static boolean isInCyan(Player p) {
        for(UUID current : cyan){
            
            if(p.getUniqueId() == current){
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    public static boolean isInYellow(Player p) {
        for(UUID current : yellow){
            
            if(p.getUniqueId() == current){
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
}
