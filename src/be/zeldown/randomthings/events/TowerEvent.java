package be.zeldown.randomthings.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import be.zeldown.randomthings.utils.ARandomEvent;

public class TowerEvent implements ARandomEvent {

	@Override
	public void perform(Player p) {
		for(int i=0;i<10;i++) {
			p.getWorld().getBlockAt(p.getLocation().getBlockX()+1, p.getLocation().getBlockY()+i, p.getLocation().getBlockZ()).setType(Material.OBSIDIAN);
		}
		for(int i=0;i<10;i++) {
			p.getWorld().getBlockAt(p.getLocation().getBlockX()-1, p.getLocation().getBlockY()+i, p.getLocation().getBlockZ()).setType(Material.OBSIDIAN);
		}
		for(int i=0;i<10;i++) {
			p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY()+i, p.getLocation().getBlockZ()+1).setType(Material.OBSIDIAN);
		}
		for(int i=0;i<10;i++) {
			p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY()+i, p.getLocation().getBlockZ()-1).setType(Material.OBSIDIAN);
		}
		p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY()-1, p.getLocation().getBlockZ()).setType(Material.OBSIDIAN);
		p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY()+9, p.getLocation().getBlockZ()).setType(Material.OBSIDIAN);
	}

	@Override
	public String name() {
		return "Tower";
	}

}
