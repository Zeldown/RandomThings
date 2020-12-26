package be.zeldown.randomthings.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import be.zeldown.randomthings.utils.ARandomEvent;

public class MLGEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		p.teleport(p.getLocation().add(0, 200, 0));
		p.getInventory().setItemInHand(new ItemStack(Material.WATER_BUCKET));
	}

	@Override
	public String name() {
		return "§4§l§nMLG !!!!";
	}

}
