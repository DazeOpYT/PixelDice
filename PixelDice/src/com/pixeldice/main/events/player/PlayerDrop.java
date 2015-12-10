package com.pixeldice.main.events.player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import com.pixeldice.main.main;

public class PlayerDrop implements Listener {
 @EventHandler
  public void PlayerDropItem(PlayerDropItemEvent e) throws InterruptedException{
   ArrayList<Player> PlayersInLobby = main.PlayersInLobby;
   List<String> Elfs = main.Elfs;
   List<String> Dwarfs = main.Dwarven;
   Item item = e.getItemDrop();
   ItemStack material = item.getItemStack();
   ItemStack bread = new ItemStack(Material.BREAD, 1);
   ItemStack bread2 = new ItemStack(Material.BREAD);
   Material type = material.getType();
   ItemMeta breadMeta = (ItemMeta) bread.getItemMeta();
	 breadMeta.setDisplayName(ChatColor.GOLD + "Peeta Bread");
	 breadMeta.addEnchant(Enchantment.DURABILITY, 1, true);
	 bread.setItemMeta(breadMeta);
 Player p = e.getPlayer();
 String name = p.getName();
		 if(PlayersInLobby.contains(p) || Elfs.contains(name) || Dwarfs.contains(name)){
           if(type == Material.NETHER_STAR){
        	   e.getItemDrop().remove();
        		 p.getInventory().setItem(4, material);
           }
	 }else{
		 if(e.getItemDrop().getItemStack().getItemMeta().equals(breadMeta)){
		    
		 }else if(type == Material.BREAD){
			 e.getPlayer().getInventory().addItem(bread);
		     e.getPlayer().getWorld().strikeLightning(e.getItemDrop().getLocation());
		     e.getItemDrop().remove();
		     e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.NOTE_PLING, 1, 1);
		     e.getPlayer().sendMessage(ChatColor.GOLD + "A magic Peeta Bread has appeared...");
		     e.getPlayer().getInventory().removeItem();

		 }	 
	
	 }
	 }
 }
