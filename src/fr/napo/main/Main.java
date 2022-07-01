package fr.napo.main;

import fr.napo.main.commands.ping;
import fr.napo.main.commands.spawn;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new EventsListener(), this);
        getCommand("spawn").setExecutor(new spawn());
        getCommand("ping").setExecutor(new ping());
    }

    @Override
    public void onDisable() {

        super.onDisable();
    }
}
