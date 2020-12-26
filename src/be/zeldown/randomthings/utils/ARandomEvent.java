package be.zeldown.randomthings.utils;

import org.bukkit.entity.Player;

public abstract class ARandomEvent {

	public abstract void perform(Player p);
	
	public abstract String name();
	
}
