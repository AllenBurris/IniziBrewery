package net.inizicraft.inizibrew;

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
	
	public void giveBrew() {
		//ItemStack item = new ItemStack(Material.GRASS,64);
		//player.getInventory().addItem(item);
	}
}
