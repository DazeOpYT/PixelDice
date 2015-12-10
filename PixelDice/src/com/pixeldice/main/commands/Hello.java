package com.pixeldice.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.ChatColor;

public class Hello implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players in game can use this command.");
			return false;
		}
		Player p = (Player) sender;
        p.sendMessage("Hello " + ChatColor.AQUA + p.getName()); 
		
        ItemStack skull = new ItemStack(Material.SKULL,1,(short) SkullType.PLAYER.ordinal());
        
        SkullMeta meta = (SkullMeta) skull;
        meta.setOwner("AntonPlaysz");
        meta.setDisplayName(p.getName());
        skull.setItemMeta(meta);
        p.getInventory().addItem(skull);
        
        return true;
		
	
		
  
	}

}
