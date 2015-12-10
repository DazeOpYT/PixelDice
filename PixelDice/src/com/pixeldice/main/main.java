package com.pixeldice.main;
 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.WorldCreator;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.pixeldice.main.commands.Hello;
import com.pixeldice.main.commands.Join;
import com.pixeldice.main.commands.Leave;
import com.pixeldice.main.commands.test;
import com.pixeldice.main.events.block.BlockBreak;
import com.pixeldice.main.events.block.BlockPlace;
import com.pixeldice.main.events.block.Projectiles;
import com.pixeldice.main.events.player.CreateSign;
import com.pixeldice.main.events.player.Food;
import com.pixeldice.main.events.player.PlayerChat;
import com.pixeldice.main.events.player.PlayerDrop;
import com.pixeldice.main.events.player.PlayerJoin;
import com.pixeldice.main.events.player.PlayerPickUp;
import com.pixeldice.main.events.player.PlayerUse;


 
 

public class main extends JavaPlugin implements Listener{
public File coins = new File(getDataFolder()+"/coins.yml");
public FileConfiguration customConfig = YamlConfiguration.loadConfiguration(coins);
public static  ArrayList<Player> PlayersInLobby = new ArrayList<Player>();
public static List<String> PlayerNames = new ArrayList<String>();
public static List<String> Elfs = new ArrayList<String>();
public static List <String> Dwarven = new ArrayList<String>();
public static int playersingame = 0;
public int counter = getConfig().getInt("Arena1");
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
        getConfig().options().copyDefaults(true);
        saveConfig();   
    }
 
    public void registerCommands(){
         getCommand("hello").setExecutor(new Hello());
         getCommand("leave").setExecutor(new Leave());
         getCommand("test").setExecutor(new test());
         getCommand("join").setExecutor(new Join());
         getConfig().options().copyDefaults(true);
         saveConfig();
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
        pm.registerEvents(new CreateSign(), this);
        pm.registerEvents(new Projectiles(), this);
        pm.registerEvents(new PlayerPickUp(), this);
    }


    
}
   


 
     



         