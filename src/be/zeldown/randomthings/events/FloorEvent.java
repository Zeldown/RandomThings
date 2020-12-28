package be.zeldown.randomthings.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import be.zeldown.randomthings.RandomThings;
import be.zeldown.randomthings.utils.ARandomEvent;

public class FloorEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		new BukkitRunnable() {
			
			int i=0;
			
			@Override
			public void run() {
				if(i > 120) {
					cancel();
				}else {
					p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).setType(Material.BEDROCK);
				}
				i++;
			}
		}.runTaskTimer(RandomThings.getInstance(), 10, 10);
	}

	@Override
	public String name() {
		return "Nouveau Sol";
	}

}
