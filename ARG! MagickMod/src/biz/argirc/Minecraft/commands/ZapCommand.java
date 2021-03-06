package biz.argirc.Minecraft.commands;

import java.lang.reflect.Array;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import biz.argirc.Minecraft.Functions.HelperFunctions;

public class ZapCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if (!HelperFunctions.isAdmin(player)) {
			player.sendMessage("You are not an admin.");
			return true;
		}
		if (Array.getLength(args) > 0) {
			for (String target : args) {
				Player p = Bukkit.getServer().getPlayer(target);
				p.getWorld().strikeLightning(p.getLocation());
			}

		}

		return true;
	}
}
