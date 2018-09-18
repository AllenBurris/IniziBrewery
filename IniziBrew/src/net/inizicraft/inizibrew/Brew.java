package net.inizicraft.inizibrew;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Brew {
	
	static String name;
	static boolean canAge = false;
	static int maxAge;
	static int currentAge;
	static boolean canDistill = false;
	static int maxRuns;
	
	
	Brew(String brewName, int brewAge, int distillRuns) {
		name = brewName;
		maxAge = brewAge;
		maxRuns = distillRuns;
		
		if(maxAge > 0) canAge = true;
		if(distillRuns > 0) canDistill = true;
		
	}
	
	public String getName() { return name;}
	public boolean getCanAge() { return canAge;}
	public int getMaxAge() { return maxAge;}
	public int getCurrentAge() { return currentAge;}
	public boolean getCanDistill() { return canDistill;}
	public int getMaxRuns() { return maxRuns;}
	
	public static void giveBrew(String name, Player sender) {
		ItemStack stack = new ItemStack(Material.POTION);
		PotionMeta meta = (PotionMeta)stack.getItemMeta();

		meta.addCustomEffect(new PotionEffect(
		        PotionEffectType.CONFUSION,     //Effect
		        300,                            //Duration in ticks
		        0),                             //Amplifier (Potion level is this + 1)
		    true                                //True = show particles, false = hide particles
		);
		meta.addCustomEffect(new PotionEffect(PotionEffects.getEffect(name) ,300,0),false);
		meta.setDisplayName("Sir's Brew");
		stack.setItemMeta(meta);
		sender.getInventory().addItem(stack);
	}
}
