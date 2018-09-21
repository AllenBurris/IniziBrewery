package net.inizicraft.inizibrew;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class IniziBrew extends JavaPlugin{
	
	private File ConfigFile;
	private FileConfiguration brewConfig;
	Brew[] brewArray;

	@Override
	public void onEnable() {
		createConfig();
		
		for(int i=0; i <= (brewConfig.getInt("totalrecipes")-1); i++) {
			brewArray[i] =  new Brew(brewConfig, String.valueOf(i));
		}
		
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
		PluginCommand command = getCommand("ib");
		command.setTabCompleter(new ImplementsTabCompleter());
		
/*		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				System.out.println("This is staying as well");
				
			}
			
		}, 0, 20); */
		System.out.println("Inizibrew Enabled");
	}
	
	public void onDisable() {
		System.out.println("Inizibrew Disabled");
	}
	
	public FileConfiguration getBrewConfig() {
		return this.brewConfig;
	}
	
	private void createConfig() {
		ConfigFile = new File(getDataFolder(), "config.yml");
		if(!ConfigFile.exists()) {
			ConfigFile.getParentFile().mkdirs();
			saveResource("config.yml", false);
		}
		
		brewConfig = new YamlConfiguration();
		try {
			brewConfig.load(ConfigFile);
		}
		catch(IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

// Commands
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// /ib
		if(label.equalsIgnoreCase("ib")) {
			if(args[0].equalsIgnoreCase("info")) { 
				sender.sendMessage("[info TBD]"); 
			}
			if(args[0].equalsIgnoreCase("help") || args[0].equals("?")) {
				sender.sendMessage("\n/ib give [Potion Effect] - gives a potion"
						+ "\n/ib info - displays Plugin info"
						+ "\n/ib help - displays this"); 
			}	
			
			if(args[0].equalsIgnoreCase("give")) {
				if(sender instanceof Player ) {
					((HumanEntity) sender).getInventory().addItem(brewArray[Integer.valueOf(args[1])].getBrew());
				}
				else
					sender.sendMessage("Only a player may execute this command.");
			}
			
			if(args[0].equalsIgnoreCase("get")) {
				sender.sendMessage(this.getBrewConfig().getString("recipes.0.ingredients"));
				sender.sendMessage(this.getBrewConfig().getString("recipes.0.effects"));
			}

		}
		
		return true;
	
	}
}
/*
  	private static int getInt(YamlConfiguration config, String name, int defaults) {
	    if (config.contains(name)) return config.getInt(name);
	    return defaults;
	}

	public static void readConfig() {
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(new File("./plugins/IniziBrew/config.yml"));
	    int myConfiguration = getInt(config,"myConfig",10);
	    System.out.println(myConfiguration);
 */

