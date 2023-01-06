package me.zoxymodz.core.cmd;

import me.zoxymodz.core.Core;
import me.zoxymodz.core.gui.MenuGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCmd implements CommandExecutor {
    private Core core;

    public MenuCmd(Core core) {
        this.core = core;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        player.openInventory(new MenuGUI(core).invMenu(player));
        return false;
    }
}
