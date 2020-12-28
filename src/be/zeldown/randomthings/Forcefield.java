package be.zeldown.randomthings;

import java.util.Random;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import be.zeldown.randomthings.executors.ForcefieldExecutor;
import lombok.Getter;
import lombok.Setter;

public class Forcefield extends JavaPlugin implements Listener {

	@Getter private static Forcefield instance;
	
	@Getter @Setter private boolean enable = false;
	
	private Random random = new Random();
	
	@Override
	public void onEnable() {
		instance = this;
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		
		getCommand("forcefield").setExecutor(new ForcefieldExecutor());
    }
	
	@Override
	public void onDisable() {}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(enable) {
			e.getPlayer().sendTitle("§eForcefield §aactif", "§2Vous êtes protégé");
		}else {
			e.getPlayer().sendTitle("§eForcefield §cdésactivé", "§a/forcefield §7pour l'activé");
		}
		new BukkitRunnable() {
			
			@Override
			public void run() {
				e.getPlayer().sendTitle("§m§l§3------§eForcefield§m§l§3-----", "§dDev by §a§lZeldown");
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.UI_TOAST_IN, 10f, 1f);
			}
		}.runTaskLater(this, 80);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		
	}
}
