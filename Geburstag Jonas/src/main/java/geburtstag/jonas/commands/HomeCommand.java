package geburtstag.jonas.commands;

import geburtstag.jonas.Jonas;
import geburtstag.jonas.utils.FileConfig;
import geburtstag.jonas.utils.LocationUtils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = (Player) sender;
        FileConfig spawns = new FileConfig("locations.yml");
        if (label.equalsIgnoreCase("setspawn")) {
            if(player.hasPermission("geburtstag.jonas.home")) {
                spawns.set("spawn", LocationUtils.loc2string(player.getLocation()));
                spawns.saveConfig(); //sollte saveConfig() sein aber ging nicht?
                player.sendMessage("§2 Spawnpunkt gesetzt.");
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2f, 1.2f);
                return true;
            } else {
                player.sendMessage("§4[Error] " + "§o§7Du hast nicht genügend rechte.");
                player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.2f, 1.4f);
            }
            return true;
        }

        if (spawns.contains("spawn")) {
            LocationUtils.teleport(player, LocationUtils.string2loc(spawns.getString("spawn")));
        } else {
            player.sendMessage("§4[Error] " + "Es wurde kein Spawnpunkt gefunden.");
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.2f, 1.4f);
        }


        return true;
    }
}
