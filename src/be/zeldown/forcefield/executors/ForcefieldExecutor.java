package be.zeldown.forcefield.executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import be.zeldown.forcefield.Forcefield;

public class ForcefieldExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Forcefield.getInstance().setEnable(!Forcefield.getInstance().isEnable());
		sender.sendMessage((Forcefield.getInstance().isEnable() ? "§a" : "§c") + "Forcefield " + (Forcefield.getInstance().isEnable() ? "§2activé" : "§4désactivé") + " !");
		return true;
	}

}
