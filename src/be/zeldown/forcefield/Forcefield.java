package be.zeldown.forcefield;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import be.zeldown.forcefield.executors.ForcefieldExecutor;
import lombok.Getter;
import lombok.Setter;

public class Forcefield extends JavaPlugin implements Listener {

	@Getter private static Forcefield instance;
	
	@Getter @Setter private boolean enable = false;
	
	private double force = 5f;
	private boolean ignoreItems = false;
	
	@Override
	public void onEnable() {
		
		saveDefaultConfig();
		
		instance = this;
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		
		getCommand("forcefield").setExecutor(new ForcefieldExecutor());
		
		this.force = getConfig().getDouble("distance");
		this.ignoreItems = getConfig().getBoolean("ignoreItems");
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
		if(enable) {
			for(Entity ent : e.getPlayer().getNearbyEntities(force, force, force)) {
				if(ignoreItems && ent instanceof Item) {
					continue;
				}
				Vector launchDirection = ent.getLocation().toVector().add(e.getPlayer().getLocation().toVector().multiply(-1));
				launchDirection.setY(1.5);
				ent.setVelocity(launchDirection);
			}
		}
	}
}
