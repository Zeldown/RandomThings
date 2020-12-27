package be.zeldown.randomthings.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class WitherEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		p.getWorld().spawnEntity(p.getLocation(), EntityType.WITHER);
		for(int i=-5;i<5;i++) {
			p.getWorld().spawnEntity(p.getLocation().add(i, 0, 0), EntityType.WITHER_SKELETON);
		}
		for(int i=-5;i<5;i++) {
			p.getWorld().spawnEntity(p.getLocation().add(0, 0, i), EntityType.WITHER_SKELETON);
		}
	}

	@Override
	public String name() {
		return "Wither Family";
	}

}
