package com.pixeldice.main.events.block;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.pixeldice.main.main;

import net.md_5.bungee.api.ChatColor;



public class BlockBreak implements Listener{
public List<String> Elfs = main.Elfs;
public List<String> Dwarfs = main.Dwarven;
public int Muur1 = 1;
	@EventHandler
    public void onBlockBreak(BlockBreakEvent event){
		Player p = event.getPlayer();
		Block block = event.getBlock();
		Material material = block.getType();
		Location Poort1b1 = new Location(Bukkit.getServer().getWorld("cave"), -376 ,21 ,-171);
		Location Poort1b2 = new Location(Bukkit.getServer().getWorld("cave"), -376 ,22 ,-171);
		Location Poort1b3 = new Location(Bukkit.getServer().getWorld("cave"), -376 ,23 ,-171);
		Location Poort1b4 = new Location(Bukkit.getServer().getWorld("cave"), -377 ,21 ,-171);
		Location Poort1b5 = new Location(Bukkit.getServer().getWorld("cave"), -377 ,22 ,-171);
		Location Poort1b6 = new Location(Bukkit.getServer().getWorld("cave"), -377 ,23 ,-171);
		if(material == Material.COBBLESTONE){
			
				if(block.getLocation().equals(Poort1b1) || block.getLocation().equals(Poort1b2) || block.getLocation().equals(Poort1b3) || block.getLocation().equals(Poort1b4) || block.getLocation().equals(Poort1b5) || block.getLocation().equals(Poort1b6)){
				if(Muur1 == 1){
					for(String s: Elfs){
						Bukkit.getPlayer(s).sendMessage(ChatColor.AQUA + "[" + ChatColor.DARK_GREEN + "C" + ChatColor.GREEN + "ave" + ChatColor.DARK_GREEN + "W" + ChatColor.GREEN + "ars" + ChatColor.AQUA + "] " + ChatColor.GOLD + "Your team has reached the Libary.");
					}
					for(String s: Dwarfs){
						Bukkit.getPlayer(s).sendMessage(ChatColor.AQUA + "[" + ChatColor.DARK_GREEN + "C" + ChatColor.GREEN + "ave" + ChatColor.DARK_GREEN + "W" + ChatColor.GREEN + "ars" + ChatColor.AQUA + "] " + ChatColor.GOLD + "The" + ChatColor.LIGHT_PURPLE + " Elfs " + ChatColor.GOLD + "has reached the libary.");
					}
					Muur1 --;
				
			}else{
				
			}
		
	}
}else{
	if(p.isOp()){
		
	}else{
		event.setCancelled(true);
	}
}
}
}