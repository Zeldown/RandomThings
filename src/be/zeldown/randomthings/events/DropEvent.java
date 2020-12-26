package be.zeldown.randomthings.events;

import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class DropEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		for(int i=0;i<p.getInventory().getSize();i++) {
			if(p.getInventory().getItem(i) != null) {
				p.getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
				p.getInventory().setItem(i, null);
			}
		}
	}

	@Override
	public String name() {
		return "Au sol";
	}

}
