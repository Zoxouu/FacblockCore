package me.zoxymodz.core.cmd;

import me.zoxymodz.core.Core;
import me.zoxymodz.core.gui.f2w.F2wGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class F2wCmd implements CommandExecutor {

    private Core core;

    public F2wCmd(Core core) {
        this.core = core;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        player.openInventory(new F2wGUI(core).invF2w(player));
        return false;
    }
}
