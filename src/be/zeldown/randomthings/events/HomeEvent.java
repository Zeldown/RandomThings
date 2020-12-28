package be.zeldown.randomthings.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class HomeEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		try {
			if(p.getBedLocation() != null) {
				p.teleport(p.getBedSpawnLocation());
			}else {
				p.teleport(new Location(p.getWorld(), 0, p.getWorld().getHighestBlockYAt(0, 0) + 1, 0));
			}
		} catch (Exception e) {
			p.teleport(new Location(p.getWorld(), 0, p.getWorld().getHighestBlockYAt(0, 0) + 1, 0));
		}
	}

	@Override
	public String name() {
		return "Retour a la maison";
	}

}
