package fr.napo.main.commands;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ping implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("ping")){
            if(sender instanceof Player){
                Player player = (Player) sender;
                EntityPlayer nmsPlayer = ((CraftPlayer) player).getHandle();

                player.sendMessage("§eVotre ping est : §6" + nmsPlayer.ping + " §eMs");
            }
        }

        return false;
    }
}
