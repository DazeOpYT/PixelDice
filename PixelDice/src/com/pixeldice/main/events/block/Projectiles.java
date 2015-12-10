package com.pixeldice.main.events.block;

import org.bukkit.Material;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class Projectiles implements Listener{

	@EventHandler
	public void onProjectiles(ProjectileHitEvent e){
		Projectile proj = e.getEntity();
		if(proj.getEntityId() == Material.SNOW_BALL.getId()){
			proj.remove();
		}
	}
}
