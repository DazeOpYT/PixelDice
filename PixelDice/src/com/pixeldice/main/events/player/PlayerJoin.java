package com.pixeldice.main.events.player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class PlayerJoin implements Listener{
   @EventHandler
   public void PlayerJoin(PlayerJoinEvent event){
	   
	  Player p = event.getPlayer();
	  PacketPlayOutTitle welcometitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"Welcome to\",\"color\":\"green\",\"bold\":true}"), 20, 40, 30);
	  PacketPlayOutTitle welcomesubtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"PixelDice\",\"color\":\"aqua\",\"bold\":true}"), 20, 40, 30);
      Location l = new Location(Bukkit.getWorld("world"), 1506, 4, -267);
      p.teleport(l);
	 PlayerConnection connection = ((CraftPlayer)p).getHandle().playerConnection;
     connection.sendPacket(welcometitle);
     connection.sendPacket(welcomesubtitle);
   
   }
}
