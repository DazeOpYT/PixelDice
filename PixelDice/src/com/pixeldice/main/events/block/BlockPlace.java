package com.pixeldice.main.events.block;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import com.pixeldice.main.main;



public class BlockPlace implements Listener {
	public List<String> Elfs = main.Elfs;
	public List<String> Dwarfs = main.Dwarven;
	public ArrayList<Player> PlayersInLobby = main.PlayersInLobby;
  @EventHandler
   public void onBlockPlace(BlockPlaceEvent event) throws InterruptedException{
	  String name = event.getPlayer().getName();
	  Player p = event.getPlayer();
	 Block block = event.getBlock();
	 Material material = block.getType();
	 if(material == Material.BEACON){
		 if(Elfs.contains(name) || Dwarfs.contains(name) || PlayersInLobby.contains(p)){
			 
		 }else{
		 block.breakNaturally();
		 Firework f = (Firework) event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Firework.class);
		 FireworkMeta fm = f.getFireworkMeta();
		 fm.addEffects(FireworkEffect.builder().flicker(true).trail(true).withColor(Color.RED).with(Type.STAR).withFade(Color.BLUE).build());
	 fm.setPower(3);
	 f.setFireworkMeta(fm);
		 }
	 }else{
		 if(material == Material.CLAY){
			 if(Elfs.contains(name) || Dwarfs.contains(name) || p.isOp()){
			TimeUnit.SECONDS.sleep(1);
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
			block.setType(Material.REDSTONE_BLOCK);
			TimeUnit.SECONDS.sleep(1);
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1); 
			block.setType(Material.CLAY);
			TimeUnit.SECONDS.sleep(1);
			Location loc = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ());
			Location loc2 = new Location(block.getWorld(), block.getX(), block.getY()+1, block.getZ());
			Block b1 = loc.getBlock().getRelative(BlockFace.NORTH);
			Block b2 = loc.getBlock().getRelative(BlockFace.EAST);
			Block b3 = loc.getBlock().getRelative(BlockFace.SOUTH);
			Block b4 = loc.getBlock().getRelative(BlockFace.WEST);
			
			Block b11 = loc2.getBlock().getRelative(BlockFace.NORTH);
			Block b22 = loc2.getBlock().getRelative(BlockFace.EAST);
			Block b33 = loc2.getBlock().getRelative(BlockFace.SOUTH);
			Block b44 = loc2.getBlock().getRelative(BlockFace.WEST);	
			p.playSound(p.getLocation(), Sound.EXPLODE, 1, 1);
					if(b1.getType() == Material.COBBLESTONE){
						b1.breakNaturally();
					}else{
						if(b2.getType() == Material.COBBLESTONE){
							b2.breakNaturally();
						}else{
							if(b3.getType() == Material.COBBLESTONE){
								b3.breakNaturally();
							}else{
								if(b4.getType() == Material.COBBLESTONE){
									b4.breakNaturally();
								}
							}
								
						}
					}
					if(b11.getType() == Material.COBBLESTONE){
						b11.breakNaturally();
					}else{
						if(b22.getType() == Material.COBBLESTONE){
							b22.breakNaturally();
						}else{
							if(b33.getType() == Material.COBBLESTONE){
								b33.breakNaturally();
							}else{
								if(b44.getType() == Material.COBBLESTONE){
									b44.breakNaturally();
								}
							}
						}
					}
			block.breakNaturally();
		 }else{
			 event.setCancelled(true);
		 }
	 }
}
  }
}
