package de.kauper.rang;
//Code © Liam Kauper 2021. Alle Rechte vorbehalten.
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Rang extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getPluginManager().registerEvents(this, this);

    }
    @EventHandler
    plublic void onJoin(PlayerJoinEvent)


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
