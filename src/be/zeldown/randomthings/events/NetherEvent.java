package be.zeldown.randomthings.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import be.zeldown.randomthings.RandomThings;
import be.zeldown.randomthings.utils.ARandomEvent;

public class NetherEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		if(RandomThings.getInstance().getNether(p) != null) {
			RandomThings.getInstance().getNether(p).setChunkForceLoaded(0, 0, true);
			p.teleport(new Location(RandomThings.getInstance().getNether(p), 0, 80, 0));
		}
	}

	@Override
	public String name() {
		return "Nether";
	}

}
