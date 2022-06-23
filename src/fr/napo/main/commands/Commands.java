package fr.napo.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Location spawn = new Location(player.getWorld(), 1.519, 71, 0.432);
            player.teleport(spawn);
        }

        return false;
    }
}
