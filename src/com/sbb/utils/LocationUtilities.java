package com.sbb.utils;

import com.sbb.handlers.SBBTeam;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LocationUtilities {
    
    public static Location spawn = new Location(Bukkit.getWorld("sbb"), -1206, 27, 386, 0, 0);
    public static Location spawn2 = new Location(Bukkit.getWorld("sbb"), -1209, 27, 386, 0, 0);
    public static Location spawn3 = new Location(Bukkit.getWorld("sbb"), -1204, 27, 386, 0, 0);
    public static Location spawn4 = new Location(Bukkit.getWorld("sbb"), -1212, 27, 386, 0, 0);
    public static Location spawn5 = new Location(Bukkit.getWorld("sbb"), -1201, 27, 386, 0, 0);
    public static Location spawn6 = new Location(Bukkit.getWorld("sbb"), -1215, 27, 386, 0, 0);
    public static Location spawn7 = new Location(Bukkit.getWorld("sbb"), -1197, 27, 386, 0, 0);
    public static Location spawn8 = new Location(Bukkit.getWorld("sbb"), -1219, 27, 386, 0, 0);
    public static Location spawn9 = new Location(Bukkit.getWorld("sbb"), -1192, 27, 386, 0, 0);
    public static Location spawn10 = new Location(Bukkit.getWorld("sbb"), -1224, 27, 386, 0, 0);
    public static Location spawn11 = new Location(Bukkit.getWorld("sbb"), -1187, 27, 386, 0, 0);
    public static Location spawn12 = new Location(Bukkit.getWorld("sbb"), -1229, 27, 386, 0, 0);

    public static Location spawn13 = new Location(Bukkit.getWorld("sbb"), -1209, 27, 416, 179, 2); 
    public static Location spawn14 = new Location(Bukkit.getWorld("sbb"), -1206, 27, 416, 179, 2); 
    public static Location spawn15 = new Location(Bukkit.getWorld("sbb"), -1212, 27, 416, 179, 2); 
    public static Location spawn16 = new Location(Bukkit.getWorld("sbb"), -1204, 27, 416, 179, 2);
    public static Location spawn17 = new Location(Bukkit.getWorld("sbb"), -1215, 27, 416, 179, 2); 
    public static Location spawn18 = new Location(Bukkit.getWorld("sbb"), -1201, 27, 416, 179, 2);
    public static Location spawn19 = new Location(Bukkit.getWorld("sbb"), -1219, 27, 416, 179, 2); 
    public static Location spawn20 = new Location(Bukkit.getWorld("sbb"), -1197, 27, 416, 179, 2); 
    public static Location spawn21 = new Location(Bukkit.getWorld("sbb"), -1224, 27, 416, 179, 2); 
    public static Location spawn22 = new Location(Bukkit.getWorld("sbb"), -1192, 27, 416, 179, 2); 
    public static Location spawn23 = new Location(Bukkit.getWorld("sbb"), -1229, 27, 416, 179, 2); 
    public static Location spawn24 = new Location(Bukkit.getWorld("sbb"), -1187, 27, 416, 179, 2); 
    
    private static Location snowball = new Location(Bukkit.getWorld("sbb"), -1207.5, 27, 401.5);
    
    private static Location cylobby = new Location(Bukkit.getWorld("sbb"), -1160.5, 27, 383.5);
    private static Location yelobby = new Location(Bukkit.getWorld("sbb"), -1160.5, 27, 419.5);

    public static void teleportToLobby(Player p) {
        
        if(SBBTeam.isInCyan(p)){
            
            p.teleport(cylobby);
            
        }else if(SBBTeam.isInYellow(p)){
            
            p.teleport(yelobby);
            
        }
        
    }

    public static void teleportToGame() {
        
        if (SBBTeam.cyan.size() == 1) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
            } else if (SBBTeam.cyan.size() == 2) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
            } else if (SBBTeam.cyan.size() == 3) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
                Bukkit.getPlayer(SBBTeam.cyan.get(2)).teleport(spawn3);
            } else if (SBBTeam.cyan.size() == 4) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
                Bukkit.getPlayer(SBBTeam.cyan.get(2)).teleport(spawn3);
                Bukkit.getPlayer(SBBTeam.cyan.get(3)).teleport(spawn4);
            } else if (SBBTeam.cyan.size() == 5) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
                Bukkit.getPlayer(SBBTeam.cyan.get(2)).teleport(spawn3);
                Bukkit.getPlayer(SBBTeam.cyan.get(3)).teleport(spawn4);
                Bukkit.getPlayer(SBBTeam.cyan.get(4)).teleport(spawn5);
            } else if (SBBTeam.cyan.size() == 6) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
                Bukkit.getPlayer(SBBTeam.cyan.get(2)).teleport(spawn3);
                Bukkit.getPlayer(SBBTeam.cyan.get(3)).teleport(spawn4);
                Bukkit.getPlayer(SBBTeam.cyan.get(4)).teleport(spawn5);
                Bukkit.getPlayer(SBBTeam.cyan.get(5)).teleport(spawn6);
            } else if (SBBTeam.cyan.size() == 7) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
                Bukkit.getPlayer(SBBTeam.cyan.get(2)).teleport(spawn3);
                Bukkit.getPlayer(SBBTeam.cyan.get(3)).teleport(spawn4);
                Bukkit.getPlayer(SBBTeam.cyan.get(4)).teleport(spawn5);
                Bukkit.getPlayer(SBBTeam.cyan.get(5)).teleport(spawn6);
                Bukkit.getPlayer(SBBTeam.cyan.get(6)).teleport(spawn7);
            } else if (SBBTeam.cyan.size() == 8) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
                Bukkit.getPlayer(SBBTeam.cyan.get(2)).teleport(spawn3);
                Bukkit.getPlayer(SBBTeam.cyan.get(3)).teleport(spawn4);
                Bukkit.getPlayer(SBBTeam.cyan.get(4)).teleport(spawn5);
                Bukkit.getPlayer(SBBTeam.cyan.get(5)).teleport(spawn6);
                Bukkit.getPlayer(SBBTeam.cyan.get(6)).teleport(spawn7);
                Bukkit.getPlayer(SBBTeam.cyan.get(7)).teleport(spawn8);
            } else if (SBBTeam.cyan.size() == 9) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
                Bukkit.getPlayer(SBBTeam.cyan.get(2)).teleport(spawn3);
                Bukkit.getPlayer(SBBTeam.cyan.get(3)).teleport(spawn4);
                Bukkit.getPlayer(SBBTeam.cyan.get(4)).teleport(spawn5);
                Bukkit.getPlayer(SBBTeam.cyan.get(5)).teleport(spawn6);
                Bukkit.getPlayer(SBBTeam.cyan.get(6)).teleport(spawn7);
                Bukkit.getPlayer(SBBTeam.cyan.get(7)).teleport(spawn8);
                Bukkit.getPlayer(SBBTeam.cyan.get(8)).teleport(spawn9);
            } else if (SBBTeam.cyan.size() == 10) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
                Bukkit.getPlayer(SBBTeam.cyan.get(2)).teleport(spawn3);
                Bukkit.getPlayer(SBBTeam.cyan.get(3)).teleport(spawn4);
                Bukkit.getPlayer(SBBTeam.cyan.get(4)).teleport(spawn5);
                Bukkit.getPlayer(SBBTeam.cyan.get(5)).teleport(spawn6);
                Bukkit.getPlayer(SBBTeam.cyan.get(6)).teleport(spawn7);
                Bukkit.getPlayer(SBBTeam.cyan.get(7)).teleport(spawn8);
                Bukkit.getPlayer(SBBTeam.cyan.get(8)).teleport(spawn9);
                Bukkit.getPlayer(SBBTeam.cyan.get(9)).teleport(spawn10);
            } else if (SBBTeam.cyan.size() == 11) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
                Bukkit.getPlayer(SBBTeam.cyan.get(2)).teleport(spawn3);
                Bukkit.getPlayer(SBBTeam.cyan.get(3)).teleport(spawn4);
                Bukkit.getPlayer(SBBTeam.cyan.get(4)).teleport(spawn5);
                Bukkit.getPlayer(SBBTeam.cyan.get(5)).teleport(spawn6);
                Bukkit.getPlayer(SBBTeam.cyan.get(6)).teleport(spawn7);
                Bukkit.getPlayer(SBBTeam.cyan.get(7)).teleport(spawn8);
                Bukkit.getPlayer(SBBTeam.cyan.get(8)).teleport(spawn9);
                Bukkit.getPlayer(SBBTeam.cyan.get(9)).teleport(spawn10);
                Bukkit.getPlayer(SBBTeam.cyan.get(10)).teleport(spawn11);
            } else if (SBBTeam.cyan.size() == 12) {
                Bukkit.getPlayer(SBBTeam.cyan.get(0)).teleport(spawn);
                Bukkit.getPlayer(SBBTeam.cyan.get(1)).teleport(spawn2);
                Bukkit.getPlayer(SBBTeam.cyan.get(2)).teleport(spawn3);
                Bukkit.getPlayer(SBBTeam.cyan.get(3)).teleport(spawn4);
                Bukkit.getPlayer(SBBTeam.cyan.get(4)).teleport(spawn5);
                Bukkit.getPlayer(SBBTeam.cyan.get(5)).teleport(spawn6);
                Bukkit.getPlayer(SBBTeam.cyan.get(6)).teleport(spawn7);
                Bukkit.getPlayer(SBBTeam.cyan.get(7)).teleport(spawn8);
                Bukkit.getPlayer(SBBTeam.cyan.get(8)).teleport(spawn9);
                Bukkit.getPlayer(SBBTeam.cyan.get(9)).teleport(spawn10);
                Bukkit.getPlayer(SBBTeam.cyan.get(10)).teleport(spawn11);
                Bukkit.getPlayer(SBBTeam.cyan.get(11)).teleport(spawn12);
            }

            if (SBBTeam.yellow.size() == 1) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
            } else if (SBBTeam.yellow.size() == 2) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
            } else if (SBBTeam.yellow.size() == 3) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
                Bukkit.getPlayer(SBBTeam.yellow.get(2)).teleport(spawn15);
            } else if (SBBTeam.yellow.size() == 4) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
                Bukkit.getPlayer(SBBTeam.yellow.get(2)).teleport(spawn15);
                Bukkit.getPlayer(SBBTeam.yellow.get(3)).teleport(spawn16);
            } else if (SBBTeam.yellow.size() == 5) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
                Bukkit.getPlayer(SBBTeam.yellow.get(2)).teleport(spawn15);
                Bukkit.getPlayer(SBBTeam.yellow.get(3)).teleport(spawn16);
                Bukkit.getPlayer(SBBTeam.yellow.get(4)).teleport(spawn17);
            } else if (SBBTeam.yellow.size() == 6) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
                Bukkit.getPlayer(SBBTeam.yellow.get(2)).teleport(spawn15);
                Bukkit.getPlayer(SBBTeam.yellow.get(3)).teleport(spawn16);
                Bukkit.getPlayer(SBBTeam.yellow.get(4)).teleport(spawn17);
                Bukkit.getPlayer(SBBTeam.yellow.get(5)).teleport(spawn18);
            } else if (SBBTeam.yellow.size() == 7) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
                Bukkit.getPlayer(SBBTeam.yellow.get(2)).teleport(spawn15);
                Bukkit.getPlayer(SBBTeam.yellow.get(3)).teleport(spawn16);
                Bukkit.getPlayer(SBBTeam.yellow.get(4)).teleport(spawn17);
                Bukkit.getPlayer(SBBTeam.yellow.get(5)).teleport(spawn18);
                Bukkit.getPlayer(SBBTeam.yellow.get(6)).teleport(spawn19);
            } else if (SBBTeam.yellow.size() == 8) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
                Bukkit.getPlayer(SBBTeam.yellow.get(2)).teleport(spawn15);
                Bukkit.getPlayer(SBBTeam.yellow.get(3)).teleport(spawn16);
                Bukkit.getPlayer(SBBTeam.yellow.get(4)).teleport(spawn17);
                Bukkit.getPlayer(SBBTeam.yellow.get(5)).teleport(spawn18);
                Bukkit.getPlayer(SBBTeam.yellow.get(6)).teleport(spawn19);
                Bukkit.getPlayer(SBBTeam.yellow.get(7)).teleport(spawn20);
            } else if (SBBTeam.yellow.size() == 9) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
                Bukkit.getPlayer(SBBTeam.yellow.get(2)).teleport(spawn15);
                Bukkit.getPlayer(SBBTeam.yellow.get(3)).teleport(spawn16);
                Bukkit.getPlayer(SBBTeam.yellow.get(4)).teleport(spawn17);
                Bukkit.getPlayer(SBBTeam.yellow.get(5)).teleport(spawn18);
                Bukkit.getPlayer(SBBTeam.yellow.get(6)).teleport(spawn19);
                Bukkit.getPlayer(SBBTeam.yellow.get(7)).teleport(spawn20);
                Bukkit.getPlayer(SBBTeam.yellow.get(8)).teleport(spawn21);
            } else if (SBBTeam.yellow.size() == 10) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
                Bukkit.getPlayer(SBBTeam.yellow.get(2)).teleport(spawn15);
                Bukkit.getPlayer(SBBTeam.yellow.get(3)).teleport(spawn16);
                Bukkit.getPlayer(SBBTeam.yellow.get(4)).teleport(spawn17);
                Bukkit.getPlayer(SBBTeam.yellow.get(5)).teleport(spawn18);
                Bukkit.getPlayer(SBBTeam.yellow.get(6)).teleport(spawn19);
                Bukkit.getPlayer(SBBTeam.yellow.get(7)).teleport(spawn20);
                Bukkit.getPlayer(SBBTeam.yellow.get(8)).teleport(spawn21);
                Bukkit.getPlayer(SBBTeam.yellow.get(9)).teleport(spawn22);
            } else if (SBBTeam.yellow.size() == 11) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
                Bukkit.getPlayer(SBBTeam.yellow.get(2)).teleport(spawn15);
                Bukkit.getPlayer(SBBTeam.yellow.get(3)).teleport(spawn16);
                Bukkit.getPlayer(SBBTeam.yellow.get(4)).teleport(spawn17);
                Bukkit.getPlayer(SBBTeam.yellow.get(5)).teleport(spawn18);
                Bukkit.getPlayer(SBBTeam.yellow.get(6)).teleport(spawn19);
                Bukkit.getPlayer(SBBTeam.yellow.get(7)).teleport(spawn20);
                Bukkit.getPlayer(SBBTeam.yellow.get(8)).teleport(spawn21);
                Bukkit.getPlayer(SBBTeam.yellow.get(9)).teleport(spawn22);
                Bukkit.getPlayer(SBBTeam.yellow.get(10)).teleport(spawn23);
            } else if (SBBTeam.yellow.size() == 12) {
                Bukkit.getPlayer(SBBTeam.yellow.get(0)).teleport(spawn13);
                Bukkit.getPlayer(SBBTeam.yellow.get(1)).teleport(spawn14);
                Bukkit.getPlayer(SBBTeam.yellow.get(2)).teleport(spawn15);
                Bukkit.getPlayer(SBBTeam.yellow.get(3)).teleport(spawn16);
                Bukkit.getPlayer(SBBTeam.yellow.get(4)).teleport(spawn17);
                Bukkit.getPlayer(SBBTeam.yellow.get(5)).teleport(spawn18);
                Bukkit.getPlayer(SBBTeam.yellow.get(6)).teleport(spawn19);
                Bukkit.getPlayer(SBBTeam.yellow.get(7)).teleport(spawn20);
                Bukkit.getPlayer(SBBTeam.yellow.get(8)).teleport(spawn21);
                Bukkit.getPlayer(SBBTeam.yellow.get(9)).teleport(spawn22);
                Bukkit.getPlayer(SBBTeam.yellow.get(10)).teleport(spawn23);
                Bukkit.getPlayer(SBBTeam.yellow.get(11)).teleport(spawn24);
            }
        
    }
    
    public static void dropBall(){
        
        snowball.getWorld().dropItem(snowball, new ItemStack(Material.SNOW_BALL));
        
    }
    
    public static Boolean isInside(Location loc, Location corner1, Location corner2) {
        
        double xMin = 0;
        double xMax = 0;
        double yMin = 0;
        double yMax = 0;
        double zMin = 0;
        double zMax = 0;
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();

        xMin = Math.min(corner1.getX(), corner2.getX());
        xMax = Math.max(corner1.getX(), corner2.getX());

        yMin = Math.min(corner1.getY(), corner2.getY());
        yMax = Math.max(corner1.getY(), corner2.getY());

        zMin = Math.min(corner1.getZ(), corner2.getZ());
        zMax = Math.max(corner1.getZ(), corner2.getZ());

        return (x >= xMin && x <= xMax && y >= yMin && y <= yMax && z >= zMin && z <= zMax);
        
    }
    
}
