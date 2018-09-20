package net.inizicraft.inizibrew;

import java.util.Scanner;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public class Brew {
	
	private static String brewNum;
	private static String name;
	private static int cookTime;
	private static boolean canAge = false;
	private static int maxAge;
	private static int currentAge;
	private static boolean canDistill = false;
	private static int maxRuns;
	private static ItemStack[] ingredients;
	private static String barrelType;
	private static int difficulty;
	private static int alcohol;
	private static ItemStack theBrew = new ItemStack(Material.POTION);
	
	
	Brew(String brewName, int brewAge, int distillRuns) {
		name = brewName;
		maxAge = brewAge;
		maxRuns = distillRuns;
		
		if(maxAge > 0) canAge = true;
		if(distillRuns > 0) canDistill = true;
		
	}
	
	Brew(FileConfiguration brewConfig, String recipeNum) {
		
		brewNum = recipeNum;
		name = brewConfig.getString("recipes." + recipeNum + ".name");
		
		String ingredientString = brewConfig.getString("recipes." + recipeNum + ".ingredients");
		
		int count = 0;
		Scanner parse = new Scanner(ingredientString).useDelimiter("/");
		while(parse.hasNext()) {
			ingredients[count] = getItemStack(parse.next(), parse.nextInt());
			count++;
		}
		parse.close();
           
		cookTime = brewConfig.getInt("recipes." + recipeNum + ".cooktime");
		maxRuns = brewConfig.getInt("recipes." + recipeNum + ".distillruns");
		if(maxRuns != 0) canDistill = true;
		barrelType = brewConfig.getString("recipes." + recipeNum + ".barrelwoodtype");
		maxAge = brewConfig.getInt("recipes." + recipeNum + ".age");
		
		String effectString = brewConfig.getString("recipes." + recipeNum + ".effects");
		PotionMeta meta = (PotionMeta)theBrew.getItemMeta();
		meta.setDisplayName(name);
		
		Scanner parseEffect  = new Scanner(effectString).useDelimiter("/");
		while(parseEffect.hasNext()) {
			meta.addCustomEffect(new PotionEffect(Effects.getEffect(parseEffect.next()) ,parseEffect.nextInt(),
					parseEffect.nextInt()),false);
			theBrew.setItemMeta(meta);
		}
		parseEffect.close();
	}
	
/*	void readIngredients(String rawIng, int number) {
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
	*/
	ItemStack getItemStack(String string, int quantity) {
		
		ItemStack stack = new ItemStack(Material.valueOf(string), quantity);
		return stack;
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
	public int getMaxRuns() { return maxRuns; }
	
	public static void giveBrew(String recipeNum, Player sender) {
		sender.getInventory().addItem(theBrew);
	}
}
