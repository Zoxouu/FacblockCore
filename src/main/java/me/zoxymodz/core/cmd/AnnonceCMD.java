package me.zoxymodz.core.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class AnnonceCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (s.length() < 2) return true;
        Player player = Bukkit.getPlayer(strings[0].replace("((","").replace("))",""));
        if (player == null) return true;
        player.kickPlayer("§7[§cAntiCheat§7] §8> §cCheating");
        Bukkit.broadcastMessage(Arrays.toString(strings).replace("(("+player.getName()+"))", "").replace(","," ").replace("[", "").replace("]","").replace("&","§"));

        return false;
    }
}
