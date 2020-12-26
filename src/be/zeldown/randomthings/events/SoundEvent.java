package be.zeldown.randomthings.events;

import java.util.Random;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import be.zeldown.randomthings.RandomThings;
import be.zeldown.randomthings.utils.ARandomEvent;

public class SoundEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		Random r = new Random();
		new BukkitRunnable() {
			
			@Override
			public void run() {
				try {
					for(int i=0;i<15+r.nextInt(50);i++) {
						p.playSound(p.getLocation(), Sound.values()[r.nextInt(Sound.values().length)], r.nextInt(150) + 50f, r.nextFloat()*4f);
						Thread.sleep(700);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.runTaskLaterAsynchronously(RandomThings.getInstance(), 10);
	}

	@Override
	public String name() {
		return "Mes oreilles !!!";
	}

}
