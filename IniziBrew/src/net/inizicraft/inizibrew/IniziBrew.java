package net.inizicraft.inizibrew;

import org.bukkit.Bukkit;

public class IniziBrew {

	void onEnabled() {
		Bukkit.getConsoleSender().sendMessage("IniziBrew Enabled");
	}
	
	void onDisable() {
		Bukkit.getConsoleSender().sendMessage("IniziBrew Disabled");
	}
	
}
