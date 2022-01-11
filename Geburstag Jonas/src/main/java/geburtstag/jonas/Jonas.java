package geburtstag.jonas;

import com.sun.org.apache.xpath.internal.objects.XString;
import geburtstag.jonas.commands.HealCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Jonas extends JavaPlugin {

    public static String PREFIX = "§4Geburtstags Plugin §7§o";
    public static Jonas INSTANCE;

    public Jonas() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.register();

        log("hat geklappt :) - Plugin geladen");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log("bye bye - Plugin wird heruntergefahren");
    }

    public void log(String text) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + text);
    }

    private void register() {
        Bukkit.getPluginCommand("heal").setExecutor(new HealCommand());
    }

}
