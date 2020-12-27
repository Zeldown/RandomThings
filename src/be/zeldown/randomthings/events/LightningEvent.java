package be.zeldown.randomthings.events;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.scheduler.BukkitRunnable;

import be.zeldown.randomthings.RandomThings;
import be.zeldown.randomthings.utils.ARandomEvent;

public class LightningEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		Random r = new Random();
		
		for(int i=0;i<10+r.nextInt(30);i++) {
			p.getWorld().strikeLightning(p.getLocation().add(r.nextInt(4)-2, 0, r.nextInt(4)-2));
		}
	}

	@Override
	public String name() {
		return "Pluie d'éclair";
	}

}
