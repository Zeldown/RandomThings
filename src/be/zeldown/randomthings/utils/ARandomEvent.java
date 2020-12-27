package be.zeldown.randomthings.utils;

import org.bukkit.entity.Player;

public abstract interface ARandomEvent {

	public abstract void perform(Player p);
	
	public abstract String name();
	
}
