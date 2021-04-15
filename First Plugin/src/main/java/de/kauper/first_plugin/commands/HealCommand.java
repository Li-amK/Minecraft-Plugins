package de.kauper.first_plugin.commands;

import de.kauper.first_plugin.First_Plugin;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            First_Plugin.INSTANCE.log("§c Dieser Befehl kann nur von einem Spieler ausgeführt werden!");
            return true;
        }

        Player player = (Player) sender;

        if (player.hasPermission("de.kauper.first_plugin.heal")) {
            player.setHealth(20d);
            player.setFoodLevel(20);
            player.sendMessage(First_Plugin.PREFIX + "§a Du wurdest geheilt!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.2f, 1.2f);
        } else {
            player.sendMessage(First_Plugin.PREFIX + "§c Dir fehlt die Berechtigung diesen befehl auszuführen!");
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.2f, 1.4f);
        }
        return true;
    }
}
