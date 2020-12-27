package be.zeldown.randomthings.events;

import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class KillEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		p.setHealth(0);
	}

	@Override
	public String name() {
		return "R.I.P";
	}

}
