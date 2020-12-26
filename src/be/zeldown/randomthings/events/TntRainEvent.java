package be.zeldown.randomthings.events;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

import be.zeldown.randomthings.utils.ARandomEvent;

public class TntRainEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		Random r = new Random();
		
		for(int i=0;i<10+r.nextInt(30);i++) {
			TNTPrimed tnt = (TNTPrimed) p.getWorld().spawnEntity(p.getLocation().add(r.nextInt(10)-5, r.nextInt(4)+3, r.nextInt(10)-5), EntityType.PRIMED_TNT);
			tnt.setFuseTicks(50);
		}
	}

	@Override
	public String name() {
		return "Pluie de TNT";
	}

}
