package com.sbb.threads;

import com.sbb.GameState;
import com.sbb.handlers.Game;
import com.sbb.utils.ChatUtilities;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GameTimer implements Runnable {

    private static int timeUntilEnd;
    
    @Override
    public void run() {
        while (true) {
            if (GameState.isState(GameState.IN_GAME)) {
                timeUntilEnd = 300;
                for (; timeUntilEnd >= 0; timeUntilEnd--) {

                    if (timeUntilEnd == 0) {
                        GameState.setState(GameState.POST_GAME);
                        Game.stop();
                        break;
                    }

                    if(timeUntilEnd == 240){
                        
                        ChatUtilities.broadcast("4 minutes left!");
                        
                    }else if(timeUntilEnd == 180){
                        
                        ChatUtilities.broadcast("3 minutes left!");
                        
                    }else if(timeUntilEnd == 120){
                        
                        ChatUtilities.broadcast("2 minutes left!");
                        
                    }else if(timeUntilEnd == 60){
                        
                        ChatUtilities.broadcast("1 minute left!");
                        
                    }else if(timeUntilEnd == 30 || timeUntilEnd < 6){
                        
                        ChatUtilities.broadcast(timeUntilEnd + " seconds left!");
                        
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
