package be.zeldown.randomthings.executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import be.zeldown.randomthings.RandomThings;

public class RandomThingsExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		RandomThings.getInstance().setEnable(!RandomThings.getInstance().isEnable());
		sender.sendMessage((RandomThings.getInstance().isEnable() ? "§a" : "§c") + "RandomThings " + (RandomThings.getInstance().isEnable() ? "§2activé" : "§4désactivé") + " !");
		return true;
	}

}
