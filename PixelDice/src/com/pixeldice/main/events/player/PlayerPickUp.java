package com.pixeldice.main.events.player;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickUp implements Listener{
   @EventHandler
   public void onPickUp(PlayerPickupItemEvent e){
	   if(e.getPlayer().isOp()){
		   
	   }else{
	  e.setCancelled(true);
	   }
   }
}
