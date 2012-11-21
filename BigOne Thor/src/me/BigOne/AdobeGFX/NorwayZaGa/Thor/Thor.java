
package me.BigOne.AdobeGFX.NorwayZaGa.Thor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Thor extends JavaPlugin
{
	public ChatColor red = ChatColor.RED;
	public ChatColor gray = ChatColor.GRAY;
	public ChatColor green = ChatColor.GREEN;
	String console = red + "Denne kommandoen kan bare bli kjørt av en spiller!";
	String permission = red + "Du har ikke permission til dette!";

  
  public void onDisable() {
    System.out.println("=========( BigOne Thor )=========");
    System.out.println("[BigOne Thor] is disabled!");
  }

  public void onEnable() {
    System.out.println("=========( BigOne Thor )=========");
    System.out.println("[BigOne Thor] is enabled!");
  }
  
public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
	  if (!(sender instanceof Player)) {
		  sender.sendMessage(console);
		  return true;
	  }
	  Player p = (Player) sender;
	  if (p.hasPermission("BigOne.thor")) {
		  if (args.length == 0) {
		  Location l = p.getTargetBlock(null, 300).getLocation();
    		  l.getWorld().strikeLightningEffect(l);
    		  return true;
	  }
	  Player tp = Bukkit.getPlayer(args[0]);
		  if (tp == null) {
				p.sendMessage(red + args[0] + " er ikke pålogget!");
				return true;
		  }
		  if (args.length >= 1) {
			  tp.getWorld().strikeLightningEffect(tp.getLocation());
			  return true;
		  }
		return false;
  }
	return false;
  }
}