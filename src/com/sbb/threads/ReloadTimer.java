package com.sbb.threads;

import com.sbb.GameState;
import com.sbb.handlers.Game;
import com.sbb.utils.ChatUtilities;
import org.bukkit.Bukkit;
public class ReloadTimer implements Runnable {

    private static int timeUntilEnd;
    
    @Override
    public void run() {
        while (true) {
            if (GameState.isState(GameState.POST_GAME)) {
                timeUntilEnd = 10;
                for (; timeUntilEnd >= 0; timeUntilEnd--) {

                    if (timeUntilEnd == 0) {
                        GameState.setState(GameState.RESET);
                        Bukkit.reload();
                        break;
                    }
                    
                    if(timeUntilEnd == 10 || timeUntilEnd < 4){
                        
                        ChatUtilities.broadcast(timeUntilEnd + " seconds till server restart!");
                        
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
