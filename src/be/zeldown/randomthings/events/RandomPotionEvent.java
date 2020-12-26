package be.zeldown.randomthings.events;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import be.zeldown.randomthings.utils.ARandomEvent;

public class RandomPotionEvent extends ARandomEvent {

	@Override
	public void perform(Player p) {
		p.addPotionEffect(new PotionEffect(PotionEffectType.values()[new Random().nextInt(PotionEffectType.values().length)], new Random().nextInt(5000) + 400, new Random().nextInt(10)));
	}

	@Override
	public String name() {
		return "Potion Aléatoire";
	}

}
