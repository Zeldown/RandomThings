package be.zeldown.randomthings;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import be.zeldown.randomthings.events.BigTntRainEvent;
import be.zeldown.randomthings.events.BordelEvent;
import be.zeldown.randomthings.events.CreeperPartyEvent;
import be.zeldown.randomthings.events.DropEvent;
import be.zeldown.randomthings.events.FireEvent;
import be.zeldown.randomthings.events.FloorEvent;
import be.zeldown.randomthings.events.HealthEvent;
import be.zeldown.randomthings.events.HomeEvent;
import be.zeldown.randomthings.events.HungerEvent;
import be.zeldown.randomthings.events.KillEvent;
import be.zeldown.randomthings.events.LavaEvent;
import be.zeldown.randomthings.events.LightningEvent;
import be.zeldown.randomthings.events.MLGEvent;
import be.zeldown.randomthings.events.NetherEvent;
import be.zeldown.randomthings.events.NoDurabilityEvent;
import be.zeldown.randomthings.events.ParticlesEvent;
import be.zeldown.randomthings.events.RandomPotionEvent;
import be.zeldown.randomthings.events.RollbackEvent;
import be.zeldown.randomthings.events.SoundEvent;
import be.zeldown.randomthings.events.SpawnMobsEvent;
import be.zeldown.randomthings.events.TntRainEvent;
import be.zeldown.randomthings.events.TowerEvent;
import be.zeldown.randomthings.events.WholeEvent;
import be.zeldown.randomthings.events.WitherEvent;
import be.zeldown.randomthings.events.ZombiePartyEvent;
import be.zeldown.randomthings.executors.RandomThingsExecutor;
import be.zeldown.randomthings.utils.ARandomEvent;
import be.zeldown.randomthings.utils.ClassCreator;
import lombok.Getter;
import lombok.Setter;

public class RandomThings extends JavaPlugin implements Listener {

	@Getter private static RandomThings instance;
	
	@Getter @Setter private boolean enable = false;
	
	@Getter List<ARandomEvent> events = new ArrayList<ARandomEvent>();
	
	private Random random = new Random();
	
	@Override
	public void onEnable() {
		instance = this;
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		
		getCommand("randomthings").setExecutor(new RandomThingsExecutor());
		
		saveDefaultConfig();
		
		getServer().getConsoleSender().sendMessage("§7[§6RandomThings7] §eLoad default event : " + (getConfig().getBoolean("default") ? "§aoui" : "§cnon"));
		if(getConfig().getBoolean("default")) {
			registerEvents();
		}
		
		if(getConfig().getBoolean("read")) {
			readFiles();
		}
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(enable) {
					for(Player p : Bukkit.getOnlinePlayers()) {
						ARandomEvent event = events.get(random.nextInt(events.size()));
						p.sendTitle("§7[§eRandomThings§7]", "§b> §a" + event.name());
						event.perform(p);
					}
				}
			}
		}.runTaskTimer(this, 600, 600);
	}

	@Override
	public void onDisable() {}
	
	private void registerEvents() {
		this.events.add(new KillEvent());
		this.events.add(new BordelEvent());
		this.events.add(new SpawnMobsEvent());
		this.events.add(new NetherEvent());
		this.events.add(new DropEvent());
		this.events.add(new TowerEvent());
		this.events.add(new TntRainEvent());
		this.events.add(new BigTntRainEvent());
		this.events.add(new LightningEvent());
		this.events.add(new SoundEvent());
		this.events.add(new FloorEvent());
		this.events.add(new CreeperPartyEvent());
		this.events.add(new ZombiePartyEvent());
		this.events.add(new ParticlesEvent());
		this.events.add(new WholeEvent());
		this.events.add(new LavaEvent());
		this.events.add(new MLGEvent());
		this.events.add(new RandomPotionEvent());
		this.events.add(new WitherEvent());
		this.events.add(new NoDurabilityEvent());
		this.events.add(new FireEvent());
		this.events.add(new HungerEvent());
		this.events.add(new HealthEvent());
		this.events.add(new HomeEvent());
		this.events.add(new RollbackEvent());
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(enable) {
			e.getPlayer().sendTitle("§eRandomThings §aactif", "§4Attention c'est dangereux");
		}else {
			e.getPlayer().sendTitle("§eRandomThings §cdésactivé", "§a/randomthings §7pour l'activé");
		}
		new BukkitRunnable() {
			
			@Override
			public void run() {
				e.getPlayer().sendTitle("§m§l§3------§eRandomThings§m§l§3-----", "§dDev by §a§lZeldown");
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 10f, 1f);
			}
		}.runTaskLater(this, 80);
	}
	
	public World getNether(Player player) {
		String nethers = null;
		World nether = null;
		for (World world : Bukkit.getServer().getWorlds()) {
			if (world.getPlayers().contains(player)) {
				nethers = world.getName() + "_nether";
				break;
			}
		}
		if(nethers != null) {
			nether = Bukkit.getServer().getWorld(nethers);
		}
		return nether;
 
	}
	

	private void readFiles() {
		getServer().getConsoleSender().sendMessage("§7[§6RandomThings7] §eReading files");
		File dir = new File(getDataFolder(), "events/");
		if(!dir.exists()) {
			dir.mkdirs();
			getServer().getConsoleSender().sendMessage("§7[§6RandomThings7] §cNo files found");
		}
		File[] files = dir.listFiles();
		List<File> loaded = new ArrayList<File>();
        for(File f : files){
            if(f.getName().endsWith(".class")) {
        		getServer().getConsoleSender().sendMessage("§7[§6RandomThings7] §eReading §b" + f.getName());
        		
            }
        }

		getServer().getConsoleSender().sendMessage("§7[§6RandomThings7] §eLoading " + loaded.size() + " files");
	}
}
