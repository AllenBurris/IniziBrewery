package net.inizicraft.inizibrew;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public class Brew {
	
	static int brewNum;
	static String name;
	static int cookTime;
	static boolean canAge = false;
	static int maxAge;
	static int currentAge;
	static boolean canDistill = false;
	static int maxRuns;
	static ItemStack[] ingredients;
	static String barrelType;
	
	
	Brew(String brewName, int brewAge, int distillRuns) {
		name = brewName;
		maxAge = brewAge;
		maxRuns = distillRuns;
		
		if(maxAge > 0) canAge = true;
		if(distillRuns > 0) canDistill = true;
		
	}
	
	Brew(FileConfiguration brewConfig, int recipeNum) {
		
		brewNum = recipeNum;
		name = brewConfig.getString(recipeNum + ".name");
		readIngredients(brewConfig.getString(recipeNum + ".ingredients"), recipeNum);
		//ingredients = brewConfig.getString(recipeNum + "ingredients");
		cookTime = brewConfig.getInt(recipeNum + ".cooktime");
		maxRuns = brewConfig.getInt(recipeNum + ".distillruns");
		if(maxRuns != 0) canDistill = true;
		barrelType = brewConfig.getString(recipeNum + ".barrelwoodtype");
		maxAge = brewConfig.getInt(recipeNum + ".age");
		
		
		
	}
	
	void readIngredients(String rawIng, int number) {
		int found = 0;
		String running = "";
		
		while(found > rawIng.length()) {
			while(rawIng.charAt(found) != ',') {
				++found;
				running+=rawIng.charAt(found-1);
				
			}
			found = found+2;
			ingredients[number] = getItemStack(running);
		}
	}
	
	ItemStack getItemStack(String string) {
		
		ItemStack stack = new ItemStack(Material.string);
		
		return null;
	}
	
	PotionMeta addBrewEffect(ItemStack item, String effect, int duration, int effectStr, boolean showParticles) {
		
		PotionMeta meta = (PotionMeta) item.getItemMeta();
		meta.addCustomEffect(new PotionEffect(Effects.getEffect(effect), duration, (effectStr-1)), showParticles);
		return meta;
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

		try {
		meta.addCustomEffect(new PotionEffect(Effects.getEffect(name) ,300,0),false);
		}
		catch(Exception e) {
			sender.sendMessage("[Inizi Brew] You must enter an effect type for the potion!");
		}
		meta.setDisplayName("Sir's Brew");
		stack.setItemMeta(meta);
		sender.getInventory().addItem(stack);
	}
}
