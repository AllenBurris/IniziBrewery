package net.inizicraft.inizibrew;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Listeners implements Listener{
	
	@EventHandler(priority=EventPriority.MONITOR, ignoreCancelled = true)
	public void method1(BlockPlaceEvent event) {
		System.out.println("Something Happened!");
	}
}
