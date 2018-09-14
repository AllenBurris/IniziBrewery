package net.inizicraft.inizibrew;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class ImplementsTabCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		ArrayList<String> out = new ArrayList<>();
		
		if(arg3.length >= 2) return out;
		
		out.add("help");
		out.add("?");
		out.add("info");
		out.add("give");
		return out;
	}

}
