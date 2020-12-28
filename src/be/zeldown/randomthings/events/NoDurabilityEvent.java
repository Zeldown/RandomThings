package be.zeldown.randomthings.events;

import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class NoDurabilityEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		if(p.getInventory().getItemInHand() != null) {
			p.getInventory().getItemInHand().setDurability(p.getInventory().getItemInHand().getType().getMaxDurability());
		}
		if(p.getInventory().getHelmet() != null) {
			p.getInventory().getHelmet().setDurability(p.getInventory().getHelmet().getType().getMaxDurability());
		}
		if(p.getInventory().getChestplate() != null) {
			p.getInventory().getChestplate().setDurability(p.getInventory().getChestplate().getType().getMaxDurability());
		}
		if(p.getInventory().getLeggings() != null) {
			p.getInventory().getLeggings().setDurability(p.getInventory().getLeggings().getType().getMaxDurability());
		}
		if(p.getInventory().getBoots() != null) {
			p.getInventory().getBoots().setDurability(p.getInventory().getBoots().getType().getMaxDurability());
		}
	}

	@Override
	public String name() {
		return "Fait attention c'est fragile";
	}

}
