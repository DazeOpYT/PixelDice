package com.pixeldice.main.commands;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.pixeldice.main.ParticleEffect;



public class test implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if(label.equalsIgnoreCase("test")){
			Location loc = p.getLocation();
			double range = 2;
			
			p.sendMessage("hello");
		}
		
		return false;
	}

}
