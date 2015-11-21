package com.pixeldice.main.events.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.pixeldice.main.main;

import net.md_5.bungee.api.ChatColor;
public class PlayerUse implements Listener{
 public List<String> Dwarven = main.Dwarven;	
 public List<String> Elfs = main.Elfs;
 public ArrayList<Player> PlayersInLobby = main.PlayersInLobby;
	public void openGUI(Player p){
		//magenta glass
		String id2 = "160:2";
		String[] splittedId2 = id2.split(":");
		int i2 = Integer.parseInt(splittedId2[0]);
		short data2 = Short.parseShort(splittedId2[1]);
		ItemStack magenta_glass = new ItemStack(Material.getMaterial(i2),1,data2);
		//brown glass
		String id3 = "160:12";
		String[] splittedId3 = id2.split(":");
		int i3 = Integer.parseInt(splittedId3[0]);
		short data3 = Short.parseShort(splittedId3[1]);
		ItemStack brown_glass = new ItemStack(Material.getMaterial(i2),1,data2);
		Inventory inv = Bukkit.createInventory(null, 9, "Team Selector");
			
		ItemStack dwarfs = new ItemStack (Material.WOOD_AXE);
		ItemMeta dwarfsmeta = dwarfs.getItemMeta();
		ItemStack elfs = magenta_glass;
		ItemMeta elfsmeta = elfs.getItemMeta();
		String id = "160:7";
		String[] splittedId = id.split(":");
		int i = Integer.parseInt(splittedId[0]);
		short data = Short.parseShort(splittedId[1]);
		ItemStack dark_glass = new ItemStack(Material.getMaterial(i),1,data);
		
		dwarfsmeta.setDisplayName(ChatColor.GOLD + "Join the dwarfs!" + " [" + ChatColor.RED + Dwarven.size() + ChatColor.GOLD + "/" + ChatColor.RED + "12" + ChatColor.GOLD + "]");
		dwarfs.setItemMeta(dwarfsmeta);
		
		elfsmeta.setDisplayName(ChatColor.DARK_PURPLE + "Join the elfs!" + ChatColor.GOLD + " [" + ChatColor.RED + Elfs.size() + ChatColor.GOLD + "/" + ChatColor.RED + "12" + ChatColor.GOLD + "]");
	
		elfs.setItemMeta(elfsmeta);
		
		inv.setItem(3, dwarfs);
		inv.setItem(5, elfs);
		inv.setItem(0, dark_glass);
		inv.setItem(1, dark_glass);
		inv.setItem(2, dark_glass);
		inv.setItem(4, dark_glass);
		inv.setItem(6, dark_glass);
		inv.setItem(7, dark_glass);
		inv.setItem(8, dark_glass);
		p.openInventory(inv);
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		//magenta glass
				String id2 = "160:2";
				String[] splittedId2 = id2.split(":");
				int i2 = Integer.parseInt(splittedId2[0]);
				short data2 = Short.parseShort(splittedId2[1]);
				ItemStack magenta_glass = new ItemStack(Material.getMaterial(i2),1,data2);
				//brown glass
				String id3 = "160:12";
				String[] splittedId3 = id2.split(":");
				int i3 = Integer.parseInt(splittedId3[0]);
				short data3 = Short.parseShort(splittedId3[1]);
				ItemStack brown_glass = new ItemStack(Material.FEATHER);
	Player p = (Player) e.getWhoClicked();
	String name = p.getName();
	
		if(!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Team Selector"))
			return;
		
		
		 if(e.getCurrentItem() == null 
				 || e.getCurrentItem().getType() == Material.NETHER_STAR 
				 || !e.getCurrentItem().hasItemMeta()){
			 p.closeInventory();
			 return;
		 }
		 
		 switch(e.getCurrentItem().getType()){
		 case FEATHER:
			 p.sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + "You've chosen the dwarf side.");
			 p.closeInventory();
			 Dwarven.add(name);
			 PlayersInLobby.remove(p);
			 break;
		 case WOOD_AXE:
			 p.sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.DARK_PURPLE + "You've chosen the elf side.");
			 p.closeInventory();
			 Elfs.add(name);
			 PlayersInLobby.remove(p);
			 break;
		   default:
			   p.closeInventory();
			   break;
		 }
	}
	
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		String name = e.getPlayer().getName();
		if(PlayersInLobby.contains(e.getPlayer()) || Elfs.contains(name) || Dwarven.contains(name)){
		Action a = e.getAction();
		ItemStack item = e.getItem();
		if(a == Action.PHYSICAL || item == null || item.getType() == Material.AIR)
			return;
		if(item.getType() == Material.NETHER_STAR){
			openGUI(e.getPlayer());
		}
	}

	}	
 
 }

