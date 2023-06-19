package eu.starhop.knockknock;

import eu.starhop.knockknock.listeners.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Knockknock extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Knock Knock is running!");
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }
}
