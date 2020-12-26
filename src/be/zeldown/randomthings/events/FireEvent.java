package be.zeldown.randomthings.events;

import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class FireEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		p.setFireTicks(2000);
	}

	@Override
	public String name() {
		return "Feu aux fesses";
	}

}
