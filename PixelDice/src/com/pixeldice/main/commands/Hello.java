package com.pixeldice.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Hello implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players in game can use this command.");
			return false;
		}
		Player p = (Player) sender;
        p.sendMessage("Hello " + ChatColor.AQUA + p.getName()); 
        
		return true;
		
	
		
  
	}

}
