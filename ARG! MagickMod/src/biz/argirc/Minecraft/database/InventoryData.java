package biz.argirc.Minecraft.database;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.avaje.ebean.validation.NotNull;

@Entity()
@Table(name = "InventoryData")
public class InventoryData implements Serializable {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -817543455386064492L;

	@NotNull
	private String				playerName;

	@Lob
	private Inventory			inventory;

	public InventoryData() {

		// this.inventory = null;
		this.playerName = "";
	}

	public InventoryData(Inventory inventory, String playerName) {
		// this.inventory = inventory;
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Player getPlayer() {
		return Bukkit.getServer().getPlayer(playerName);
	}

	public void setPlayer(Player player) {
		this.playerName = player.getName();
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Inventory getInventory() {
		return inventory;
	}

	// public void setInventory(Inventory inventory) {
	// this.inventory = inventory;
	// }

	// public Inventory getInventory() {
	// return inventory;
	// }

}
