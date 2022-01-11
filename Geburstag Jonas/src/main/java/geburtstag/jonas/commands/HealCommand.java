package geburtstag.jonas.commands;

import geburtstag.jonas.Jonas;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)) {
            Jonas.INSTANCE.log("Deine Klasse kann nicht heilen!");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("geburtstag.jonas.heal")) {
            player.setHealth(20d);
            player.sendMessage("§2[Heiler] " +"§o§7Du hast dich mit deinen Fähigkeiten geheilt.");
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2f, 1.2f);
        } else {
            player.sendMessage("§4[Error] " + "§o§7Du kannst dich nicht heilen.");
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.2f, 1.4f);
        }



        return true;
    }
}
