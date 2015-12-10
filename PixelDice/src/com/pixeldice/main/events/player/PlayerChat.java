package com.pixeldice.main.events.player;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {
	
	 public static String prefixOP = "§b[§aOwner§b]§b";
	 public static String player = "[Player]";
  @EventHandler
  public void onPlayerChat(AsyncPlayerChatEvent e){
      Player p = e.getPlayer();
      String message = e.getMessage();
      message = message.replace("&", "§");
      if(p.isOp()){
    	  e.setFormat(prefixOP + "§f" + p.getName() + " > " + message); 
      }else{
    	  e.setFormat(player + p.getName() + "> " + message);  
      }
  }
}
