package com.pixeldice.main.events.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import com.pixeldice.main.main;

import net.md_5.bungee.api.ChatColor;

public class PlayerLeave implements Listener {
	public ArrayList<Player> PlayersInLobby = main.PlayersInLobby;
	public List<String> PlayerNames = main.PlayerNames;
	public List<String> Elfs = main.Elfs;
	public List<String> Dwarven = main.Dwarven;
   @EventHandler
  public void onPlayerQuit(PlayerQuitEvent e){
	   ItemStack selector = new ItemStack(Material.NETHER_STAR);
	   Player p = e.getPlayer();
	   String name = p.getName();
	   if(PlayersInLobby.contains(p)){
		   p.getInventory().remove(selector);
		   PlayersInLobby.remove(p);
		   PlayerNames.remove(p.getName());
		   for(String s: PlayerNames){  
		if(Dwarven.contains(name)){
		   Dwarven.remove(name);
	   }else{
		   if(Elfs.contains(name)){
			   Elfs.remove(name);
		   }
			   Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + p.getName() + ChatColor.AQUA + " has left " + ChatColor.DARK_GREEN + "C" + ChatColor.GREEN + "ave" + ChatColor.DARK_GREEN + "W" + ChatColor.GREEN + "ars. " + ChatColor.RED + "[" + ChatColor.GOLD + PlayersInLobby.size() + "/" + "16" + ChatColor.RED + "]");
		   }
	   }
	 
	   }
   }
}
