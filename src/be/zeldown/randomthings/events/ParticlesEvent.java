package be.zeldown.randomthings.events;

import java.util.Random;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import be.zeldown.randomthings.RandomThings;
import be.zeldown.randomthings.utils.ARandomEvent;

public class ParticlesEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		Random r = new Random();
		new BukkitRunnable() {
			
			int i=0;
			
			@Override
			public void run() {
				if(i > 200) {
					cancel();
				}else {
					p.spawnParticle(Particle.values()[r.nextInt(Particle.values().length)], p.getLocation(), 1000);
				}
				i++;
			}
		}.runTaskTimer(RandomThings.getInstance(), 5, 5);
	}

	@Override
	public String name() {
		return "On y voit plus rien";
	}

}
