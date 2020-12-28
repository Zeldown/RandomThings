package be.zeldown.randomthings.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class WholeEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		for(int ox=-10;ox<10;ox++) {
			for(int oz=-10;oz<10;oz++) {
				for(int i=p.getLocation().getBlockY();i>0;i--) {
					Location loc = p.getLocation().add(ox, 0, oz);
					loc.setY(i);
					p.getWorld().getBlockAt(loc).setType(Material.AIR);
				}
			}
		}
	}

	@Override
	public String name() {
		return "Mineur";
	}

}
