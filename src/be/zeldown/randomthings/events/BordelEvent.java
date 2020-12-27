package be.zeldown.randomthings.events;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import be.zeldown.randomthings.utils.ARandomEvent;

public class BordelEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		for(int i=0;i<p.getInventory().getSize();i++) {
			int slot = new Random().nextInt(p.getInventory().getSize());
			ItemStack item = p.getInventory().getItem(slot);
			int slot2  = new Random().nextInt(p.getInventory().getSize());
			ItemStack item2 = p.getInventory().getItem(slot2);
			
			p.getInventory().setItem(slot2, item);
			p.getInventory().setItem(slot, item2);
		}
	}

	@Override
	public String name() {
		return "C'est le bordel";
	}

}
