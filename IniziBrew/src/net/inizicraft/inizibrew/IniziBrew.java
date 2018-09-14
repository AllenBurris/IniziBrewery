package net.inizicraft.inizibrew;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class IniziBrew extends JavaPlugin{

	@Override
	public void onEnable() {
		System.out.println("Inizibrew Enabled");
		
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
		PluginCommand command = getCommand("ib");
		command.setTabCompleter(new ImplementsTabCompleter());
		
/*		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				System.out.println("This is staying as well");
				
			}
			
		}, 0, 20); */
	}
	
	public void onDisable() {
		System.out.println("Inizibrew Disabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("brewtest")) {
			sender.sendMessage("Boo!"); 
		}
		// /ib
		if(label.equalsIgnoreCase("ib")) {
			if(args[0].equalsIgnoreCase("info")) { 
				sender.sendMessage("[info TBD]"); 
			}
			if(args[0].equalsIgnoreCase("help") || args[0].equals("?")) {
				sender.sendMessage("\n/ib brewtest - a test command"
						+ "\n/ib info - displays Plugin info"
						+ "\n/ib help - displays this"); 
			}	
			
			if(args[0].equalsIgnoreCase("give")) {
				if(sender instanceof Player ) {
					Brew.giveBrew("Speed", ((Player) sender));
				}
				else
					sender.sendMessage("Only a player may execute this command.");
			}
		}
			
		return true;
	}
}

