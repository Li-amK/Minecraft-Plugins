package de.kauper.first_plugin;

import de.kauper.first_plugin.commands.HealCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class First_Plugin extends JavaPlugin {

    public static String PREFIX = "§9Liam's Plugin §a§o";
    public static First_Plugin INSTANCE;

    public First_Plugin() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.register();

        log("Plugin 'Erstes Plugin' erfolgreich geladen.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log("Plugin wird beendet...");
        log("Bis bald!");
    }

    public void log(String text) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + text);
    }

    private void register() {
        Bukkit.getPluginCommand("heal").setExecutor(new HealCommand());
    }
}
