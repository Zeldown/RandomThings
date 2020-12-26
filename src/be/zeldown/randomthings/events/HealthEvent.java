package be.zeldown.randomthings.events;

import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class HealthEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		p.setHealth(0.5d);
	}

	@Override
	public String name() {
		return "Aie";
	}

}
