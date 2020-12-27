package be.zeldown.randomthings.events;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class ZombiePartyEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		Random r = new Random();
		for(int i=0;i<20+r.nextInt(50);i++) {
			p.getWorld().spawnEntity(p.getLocation().add(r.nextInt(10)-5, 1, r.nextInt(10)-5), EntityType.ZOMBIE);
		}
	}

	@Override
	public String name() {
		return "Zombie Party";
	}

}
