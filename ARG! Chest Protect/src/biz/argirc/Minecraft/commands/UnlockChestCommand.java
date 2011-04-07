package biz.argirc.Minecraft.commands;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import biz.argirc.Minecraft.MagickMod;
import biz.argirc.Minecraft.database.ChestData;

public class UnlockChestCommand implements CommandExecutor {
	private final MagickMod	plugin;

	public UnlockChestCommand(MagickMod plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		Block chestToLock = player.getTargetBlock(null, 5);

		if (chestToLock.getTypeId() == 54) {
			String owner = plugin.chestFunctions.getOwner(chestToLock.getLocation());
			if (owner.equalsIgnoreCase(player.getName())) {
				ChestData myChest = plugin.chestFunctions.getChest(chestToLock.getLocation());
				myChest.setName("public");
				plugin.getDatabase().save(myChest);
			}

		}

		return true;
	}
}