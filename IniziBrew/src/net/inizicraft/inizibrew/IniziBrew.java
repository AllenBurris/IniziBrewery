package net.inizicraft.inizibrew;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
				
				if(sender instanceof Player) {
					ItemStack stack = new ItemStack(Material.POTION);
					PotionMeta meta = (PotionMeta)stack.getItemMeta();

					//Add potion effects (can be any!)
					meta.addCustomEffect(new PotionEffect(
					        PotionEffectType.CONFUSION,        //Effect
					        300,                            //Duration in ticks
					        0),                             //Amplifier (Potion level is this + 1)
					    true                                //True = show particles, false = hide particles
					);
					meta.addCustomEffect(new PotionEffect(PotionEffectType.HUNGER,300,0),true);
					meta.setDisplayName("Sir's Brew");
					stack.setItemMeta(meta);
					((Player)sender).getInventory().addItem(stack);
				}
				else
					sender.sendMessage("Only a Player may execute this command.");
			}
		}
			
		return true;
	}
}

