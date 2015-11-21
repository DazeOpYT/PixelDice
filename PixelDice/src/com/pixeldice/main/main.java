package com.pixeldice.main;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
 
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.pixeldice.main.*;
 
import com.pixeldice.main.commands.Hello;
import com.pixeldice.main.commands.Leave;
import com.pixeldice.main.events.block.BlockBreak;
import com.pixeldice.main.events.block.BlockPlace;
import com.pixeldice.main.events.player.Food;
import com.pixeldice.main.events.player.PlayerChat;
import com.pixeldice.main.events.player.PlayerDrop;
import com.pixeldice.main.events.player.PlayerJoin;
import com.pixeldice.main.events.player.PlayerUse;

import net.md_5.bungee.api.ChatColor;
 
 
 
public class main extends JavaPlugin implements Listener{
public static  ArrayList<Player> PlayersInLobby = new ArrayList<Player>();
public static List<String> PlayerNames = new ArrayList<String>();
public static List<String> Elfs = new ArrayList<String>();
public static List <String> Dwarven = new ArrayList<String>();
public static int playersingame = 0;
public static int counter = 60;
public static int game = 1;
public static int ItemSpawn = 0;
      public void onEnable(){
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();
        registerEvents();
        registerCommands();
        logger.info(pdfFile.getName() + " is running.");
        getServer().createWorld(new WorldCreator("cave"));
        getServer().createWorld(new WorldCreator("world"));
         
    }
 
    public void onDisable(){
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();
        logger.info(pdfFile.getName() + "has shutdown.");
    }

    public void registerCommands(){
         getCommand("hello").setExecutor(new Hello());
         getCommand("leave").setExecutor(new Leave());
    }
    public void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Food(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new BlockBreak(), this);
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new BlockPlace(), this);
        pm.registerEvents(new PlayerDrop(), this);
        pm.registerEvents(new PlayerUse(), this);
      
    }
    public ArrayList<Player> PlayersInLobby(){
        return PlayersInLobby;
    }

@SuppressWarnings("deprecation")
@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
     Player p = (Player)sender;
     String name = p.getName();


        if(label.equalsIgnoreCase("join")){
        	if(game == 1){
            if(PlayersInLobby.size() >= 24){
                p.sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.RED + "This game is full.");  
            }else{
            if(PlayersInLobby.contains(p)){
                 p.sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + "You've already joined this game.");
             }else{
            	 p.getInventory().clear();
                 p.getInventory().addItem(new ItemStack(Material.NETHER_STAR));
                if(PlayersInLobby.size() > -1){
              if(counter == 60){
                  this.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
                      
                      public void run() {
                       if(counter != -1){
                           if(counter != 0){
                              if(counter == 60){
                                   for(String s: PlayerNames){
                                       Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + "The game will start in " + ChatColor.RED + "1" + ChatColor.GOLD + " minute.");
                                      Bukkit.getPlayer(s).playSound(Bukkit.getPlayer(s).getLocation(), Sound.LEVEL_UP, 1, 1);
                                   }
                                   }else{ if(counter == 45){
                                   for(String s: PlayerNames){
                                       Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + "The game will start in " + ChatColor.RED + "45" + ChatColor.GOLD + " seconds.");
                                       Bukkit.getPlayer(s).playSound(Bukkit.getPlayer(s).getLocation(), Sound.LEVEL_UP, 1, 1);
                                   }
                                   }else{
                                        if(counter == 30){
                                       for(String s: PlayerNames){
                                           Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + "The game will start in " + ChatColor.RED + "30" + ChatColor.GOLD + " seconds.");
                                           Bukkit.getPlayer(s).playSound(Bukkit.getPlayer(s).getLocation(), Sound.LEVEL_UP, 1, 1);
                                       }
                                   }else{
                                       if(counter == 15){
                                           for(String s: PlayerNames){
                                               Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + "The game will start in " + ChatColor.RED + "15" + ChatColor.GOLD + " seconds.");
                                               Bukkit.getPlayer(s).playSound(Bukkit.getPlayer(s).getLocation(), Sound.LEVEL_UP, 1, 1);
                                           }
                                   }else{
                                       if(counter == 10){
                                                 
                                                   for(String s: PlayerNames){
                                                   Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + "The game will start in " + ChatColor.RED + "10" + ChatColor.GOLD + " seconds.");
                                                   Bukkit.getPlayer(s).playSound(Bukkit.getPlayer(s).getLocation(), Sound.LEVEL_UP, 1, 1);
                                                   }
                                   }else{
                                       if(counter < 6){
                                           for(String s: PlayerNames){
                                               Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + "The game will start in " + ChatColor.RED + counter + ChatColor.GOLD + " seconds.");
                                               Bukkit.getPlayer(s).playSound(Bukkit.getPlayer(s).getLocation(), Sound.WOOD_CLICK, 1, 1);
                                               }
                                       }else{
                                     
                                       }
                                   }
                                 
                                     
                                             
                                   }
                               }
                               }
                              }
                             
                               counter --;
                           }else{
                               int item1firstid = 95;
                               int item1secondid= 2;
                               int item1r = 32;
                               int item2r = 4;
                               int chest1r = 27;
                               Random randomslot1 = new Random();
                               Random randomslot2 = new Random();
                               Random randomitem1 = new Random();
                               Random randomitem2 = new Random();
                               ItemStack clay = new ItemStack(Material.CLAY);
                               ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
                               ItemStack wood_pick = new ItemStack(Material.WOOD_PICKAXE);
                               ItemStack chain_chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                               ItemStack chain_legs =  new ItemStack(Material.CHAINMAIL_LEGGINGS);	   
                               ItemStack stone_sword = new ItemStack(Material.STONE_SWORD);
                               ItemStack apple = new ItemStack(Material.APPLE, 3);
                               ItemStack iron_sword = new ItemStack(Material.IRON_SWORD);
                               ItemStack cooked_beef = new ItemStack(Material.COOKED_BEEF, 5);
                               ItemStack golden_apple = new ItemStack(Material.GOLDEN_APPLE, 2);
                               ItemStack wood = new ItemStack(Material.WOOD, randomitem1.nextInt(item1r)+1);
                               ItemStack iron_helmet = new ItemStack(Material.IRON_HELMET);
                               ItemStack iron_chest = new ItemStack(Material.IRON_CHESTPLATE);
                               ItemStack iron_legs = new ItemStack(Material.IRON_LEGGINGS);
                               ItemStack iron_boots = new ItemStack(Material.IRON_BOOTS);
                               ItemStack bread = new ItemStack(Material.BREAD);
                               ItemStack potato = new ItemStack(Material.BAKED_POTATO);
                               Location chest1 = new Location(Bukkit.getServer().getWorld("cave"),-371, 37, -204 );
                               Chest chest11 = (Chest) chest1.getBlock().getState();
                               //chest1
                               
                                   chest11.getInventory().setItem(randomslot1.nextInt(chest1r), stone_sword);
                                   chest11.getInventory().setItem(randomslot1.nextInt(chest1r), cooked_beef);
                             
                                   
                               
                             
                               //chest2
                                Location chest2 = new Location(Bukkit.getServer().getWorld("cave"), -374, 30, -209);
                                Chest chest22 = (Chest) chest2.getBlock().getState();
                         
                                    chest22.getInventory().setItem(randomslot2.nextInt(chest1r), golden_apple);
                                    chest22.getInventory().setItem(randomslot2.nextInt(chest1r), stone_sword);
                                    chest22.getInventory().setItem(randomslot2.nextInt(chest1r), iron_helmet);
                                    chest22.getInventory().setItem(randomslot2.nextInt(chest1r), apple);
                               //chest3
                                Location chest3 = new Location(Bukkit.getServer().getWorld("cave"), -366, 36, -209);    
                                Chest chest33 = (Chest) chest3.getBlock().getState();
                                chest33.getInventory().setItem(randomslot2.nextInt(chest1r), golden_apple);
                                chest33.getInventory().setItem(randomslot2.nextInt(chest1r), wood);
                                chest33.getInventory().setItem(randomslot2.nextInt(chest1r), iron_legs);
                                chest33.getInventory().setItem(randomslot2.nextInt(chest1r), bread);
                                chest33.getInventory().setItem(randomslot2.nextInt(chest1r), iron_boots);
                               //chest4
                                Location chest4 = new Location(Bukkit.getServer().getWorld("cave"), -366, 35, -210);
                                Chest chest44 = (Chest) chest4.getBlock().getState();
                                chest44.getInventory().setItem(randomslot2.nextInt(chest1r), iron_sword);
                                chest44.getInventory().setItem(randomslot2.nextInt(chest1r), iron_helmet);
                                chest44.getInventory().setItem(randomslot2.nextInt(chest1r), bread);
                                chest44.getInventory().setItem(randomslot2.nextInt(chest1r), wood);
                                chest44.getInventory().setItem(randomslot2.nextInt(chest1r), apple);
                               //chest5
                                Location chest5 = new Location(Bukkit.getWorld("cave"), -366, 36, -211);
                                Chest chest55 = (Chest) chest5.getBlock().getState(); 
                                
                                chest55.getInventory().setItem(randomslot2.nextInt(chest1r), iron_sword);
                                chest55.getInventory().setItem(randomslot2.nextInt(chest1r), iron_chest);
                                chest55.getInventory().setItem(randomslot2.nextInt(chest1r), bread);
                                chest55.getInventory().setItem(randomslot2.nextInt(chest1r), wood_pick);
                                chest55.getInventory().setItem(randomslot2.nextInt(chest1r), apple);
                               //chest6
                                Location chest6 = new Location(Bukkit.getWorld("cave"), -371, 21, -203);
                                Chest chest66 = (Chest) chest6.getBlock().getState(); 
                                
                                chest66.getInventory().setItem(randomslot2.nextInt(chest1r), chain_legs);
                                chest66.getInventory().setItem(randomslot2.nextInt(chest1r), diamond);
                                chest66.getInventory().setItem(randomslot2.nextInt(chest1r), bread);
                                chest66.getInventory().setItem(randomslot2.nextInt(chest1r), wood_pick);
                                chest66.getInventory().setItem(randomslot2.nextInt(chest1r), potato);
                                chest66.getInventory().setItem(randomslot2.nextInt(chest1r), apple);
                                //chest7
                                 Location chest7 = new Location(Bukkit.getWorld("cave"), -371, 25, -202);
                                 Chest chest77 = (Chest) chest7.getBlock().getState();
                                 chest77.getInventory().setItem(randomslot2.nextInt(chest1r), diamond);
                                 chest77.getInventory().setItem(randomslot2.nextInt(chest1r), iron_sword);
                                 chest77.getInventory().setItem(randomslot2.nextInt(chest1r), chain_chest);
                                 chest77.getInventory().setItem(randomslot2.nextInt(chest1r), golden_apple);
                                 chest77.getInventory().setItem(randomslot2.nextInt(chest1r), clay);
                               //group teleport system
                               for(String s: Elfs){
                                   p.getInventory().clear();
                                   Location elfs = new Location(Bukkit.getServer().getWorld("cave"), -372, 37, -216);
                                   Bukkit.getPlayer(s).teleport(elfs);
                                   Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + "Good luck...");
                                   Bukkit.getPlayer(s).playSound(Bukkit.getPlayer(s).getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
                                   }
                                   for(String s: Dwarven){
                                   p.getInventory().clear();
                                   Location dwarfs = new Location(Bukkit.getServer().getWorld("cave"), -377,20,-183);    
                                   Bukkit.getPlayer(s).teleport(dwarfs);
                                   Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + "Good luck...");
                                   Bukkit.getPlayer(s).playSound(Bukkit.getPlayer(s).getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
                                   }
                                   if(PlayersInLobby.contains(p)){
                                       if(Dwarven.size() > Elfs.size()){
                                           p.getInventory().clear();
                                           Elfs.add(name);
                                           Location elfs = new Location(Bukkit.getServer().getWorld("cave"), -372, 37, -216);
                                           p.teleport(elfs);
                                           PlayersInLobby.remove(p);
                                       }else {
                                           if(Elfs.size() > Dwarven.size()){
                                               p.getInventory().clear();
                                               Location dwarfs = new Location(Bukkit.getServer().getWorld("cave"), -377,20,-183);    
                                               Dwarven.add(name);
                                               PlayersInLobby.remove(p);
                                               p.teleport(dwarfs);
                                           }else {
                                               if(Elfs.size() == Dwarven.size()){
                                                   p.getInventory().clear();
                                                   Elfs.add(name);
                                                   Location elfs = new Location(Bukkit.getServer().getWorld("cave"), -372, 37, -216);
                                                   p.teleport(elfs);
                                                   PlayersInLobby.remove(p);
                                               }
                                 
                                         
                                       }
                                   }
                                 
                                   }
                               counter --;
                               game --;
                           }
                       }else{
                       
                       }
                      }
                      }
                      , 0L, 20L);
              }

              }		
            Location lobby = new Location(Bukkit.getWorld("cave"), -320, 55, -57);
            p.teleport(lobby);
             PlayersInLobby.add(p);
             PlayerNames.add(p.getName());
            for(String s : PlayerNames){
                  Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "PixelDice" + ChatColor.BLUE + "] " + ChatColor.GOLD + p.getName() + ChatColor.AQUA + " has joined " + ChatColor.DARK_GREEN + "C" + ChatColor.GREEN + "ave" + ChatColor.DARK_GREEN + "W" + ChatColor.GREEN + "ars. " + ChatColor.RED + "[" + ChatColor.GOLD + PlayersInLobby.size() + "/" + "24" + ChatColor.RED + "]");
                }
       
        }
            }  

    }
        }else{
        	
        }

		return false;
}

}

         