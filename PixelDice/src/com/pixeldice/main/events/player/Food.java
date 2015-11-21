package com.pixeldice.main.events.player;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Food implements Listener{
    public void onFoodLevelChange(FoodLevelChangeEvent e){
    	e.setFoodLevel(20);
    }
}
