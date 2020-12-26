package be.zeldown.randomthings.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class LavaEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		for(int ox=-10;ox<10;ox++) {
			for(int oz=-10;oz<10;oz++) {
				for(int i=0;i<3;i++) {
					Location loc = p.getLocation().add(ox, i, oz);
					p.getWorld().getBlockAt(loc).setType(Material.LAVA);
				}
			}
		}
	}

	@Override
	public String name() {
		return "Piscine (de lave)";
	}

}
