package be.zeldown.randomthings.events;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

import be.zeldown.randomthings.utils.ARandomEvent;

public class BigTntRainEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		Random r = new Random();
		
		for(int i=0;i<50+r.nextInt(60);i++) {
			TNTPrimed tnt = (TNTPrimed) p.getWorld().spawnEntity(p.getLocation().add(r.nextInt(30)-15, r.nextInt(4)+3, r.nextInt(30)-15), EntityType.PRIMED_TNT);
			tnt.setFuseTicks(50);
		}
	}

	@Override
	public String name() {
		return "(Grosse) Pluie de TNT";
	}

}
