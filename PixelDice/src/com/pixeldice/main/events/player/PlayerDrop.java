package com.pixeldice.main.events.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import com.pixeldice.main.main;

public class PlayerDrop implements Listener {
 @EventHandler
  public void PlayerDropItem(PlayerDropItemEvent e){
   ArrayList<Player> PlayersInLobby = main.PlayersInLobby;
   List<String> Elfs = main.Elfs;
   List<String> Dwarfs = main.Dwarven;
   Item item = e.getItemDrop();
   ItemStack material = item.getItemStack();
   Material type = material.getType();
 Player p = e.getPlayer();
 String name = p.getName();
	 if(p.isOp()){
		 
	 }else{
		 if(PlayersInLobby.contains(p) || Elfs.contains(name) || Dwarfs.contains(name)){
           if(type == Material.NETHER_STAR){
        	   e.getItemDrop().remove();
        		 p.getInventory().addItem(material);
           }
	 }else{
	 e.getItemDrop().remove();
	 
	 p.getInventory().addItem(material);
	 }
	 }
 }
}
