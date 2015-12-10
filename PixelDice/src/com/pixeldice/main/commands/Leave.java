package com.pixeldice.main.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.pixeldice.main.main;

import net.md_5.bungee.api.ChatColor;

public class Leave implements CommandExecutor {
public ArrayList<Player> PlayersInLobby = main.PlayersInLobby;
public List<String> PlayerNames = main.PlayerNames;	
public List<String> Elfs = main.Elfs;
public List<String> Dwarfs = main.Dwarven;
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		Player p = (Player)sender;
		String name = p.getName();
		      if(!(sender instanceof Player)){
		    	  
		      }
		      if(PlayersInLobby.contains(p)){
		    	  PlayersInLobby.remove(p);
		    	  p.getInventory().clear();
		    	  Location lobby = new Location(Bukkit.getWorld("cave"), -320, 55, -57);
		          p.teleport(lobby); 
		          if(Elfs.contains(p.getName())){
		        	  Elfs.remove(p.getName());
		        	  p.getInventory().clear();
			          p.teleport(lobby); 
			          PlayersInLobby.remove(p);
		          }
		          if(Dwarfs.contains(p.getName())){
		        	  Dwarfs.remove(p.getName());
		        	  p.getInventory().clear();
			          p.teleport(lobby); 
			          PlayersInLobby.remove(p);
		          }
		      }
		      
		      
		return false;
	}

}
