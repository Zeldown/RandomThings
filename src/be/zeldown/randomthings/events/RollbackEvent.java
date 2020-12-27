package be.zeldown.randomthings.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import be.zeldown.randomthings.RandomThings;
import be.zeldown.randomthings.utils.ARandomEvent;

public class RollbackEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		new BukkitRunnable() {
			
			int i = 0;
			Location last = null;
			
			@Override
			public void run() {
				if(i >= 100) {
					cancel();
				}
				if(last == null) {
					last = p.getLocation();
				}else if(i%5 == 0){
					p.teleport(last);
				}else if(i%2 == 0){
					last = p.getLocation();
				}
				i++;
			}
		}.runTaskTimer(RandomThings.getInstance(), 10, 10);
	}

	@Override
	public String name() {
		return "Rollback";
	}

}
