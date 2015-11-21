package com.pixeldice.main.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {
  @EventHandler
  public void onPlayerChat(AsyncPlayerChatEvent event){
	  Player p = event.getPlayer();
	  String message = event.getMessage();
	  if(message.contains("banana")){
		  event.setCancelled(true);
	  }
  }
}
