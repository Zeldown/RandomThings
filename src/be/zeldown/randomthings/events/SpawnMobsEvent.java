package be.zeldown.randomthings.events;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class SpawnMobsEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		Random r = new Random();
		for(int i=0;i<r.nextInt(20);i++) {
			p.getWorld().spawnEntity(p.getLocation().add(r.nextInt(6) - 3, 2, r.nextInt(6) - 3), EntityType.values()[r.nextInt(EntityType.values().length)]);
		}
	}

	@Override
	public String name() {
		return "Mob en folie";
	}

}
