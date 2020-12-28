package be.zeldown.randomthings.events;

import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class HungerEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		p.setFoodLevel(0);
	}

	@Override
	public String name() {
		return "J'ai faim";
	}

}
