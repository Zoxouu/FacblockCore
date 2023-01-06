package me.zoxymodz.core.listeners;

import me.zoxymodz.core.Core;
import net.luckperms.api.model.group.Group;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.lang.reflect.Field;

public class PlayerListener implements Listener {

    private Core core;
    public PlayerListener(Core core) {
        this.core = core;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Group group = (Group) core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup());
        event.setJoinMessage(ChatColor.GREEN+"+ " +group.getCachedData().getMetaData().getPrefix()+player.getName());
        EntityPlayer eplayer = ((CraftPlayer) player).getHandle();
        PacketPlayOutPlayerListHeaderFooter hp = new PacketPlayOutPlayerListHeaderFooter(IChatBaseComponent.ChatSerializer.a("{\"text\":\""+"\n§6§lFacBlock PvP/Cheat\n\n"+centerText("§eServeur Minecraft PvP/Faction Cheat Farm2Win !",40)+"\n"+"\"}"));
        try {
            Field field = hp.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(hp, IChatBaseComponent.ChatSerializer.a("{\"text\":\""+"\n§7www.facblock.fr\n"+"\"}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        eplayer.playerConnection.sendPacket(hp);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        Group group = (Group) core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup());
        event.setQuitMessage(ChatColor.RED+"- " +group.getCachedData().getMetaData().getPrefix()+player.getName());
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Group group = (Group) core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup());
        if (event.getMessage().contains(player.getName())) player.playSound(player.getLocation(),Sound.LEVEL_UP,100,100);
        if (player.hasPermission("core.chat.color")) {
            if (event.getMessage().contains("&")) event.setMessage(event.getMessage().replaceAll("&","§"));
        }
        event.setFormat(group.getCachedData().getMetaData().getPrefix()+" "+player.getDisplayName()+ ChatColor.GRAY +" \u27a2 " + event.getMessage());

        //if (event.getMessage().equalsIgnoreCase("test")) player.openInventory(RankGUI.get().invRank(player));
    }

    private String centerText(String text, int lineLength) {
        StringBuilder builder = new StringBuilder(text);
        char space = ' ';
        int distance = (lineLength - text.length()) / 2;
        for (int i = 0; i < distance; ++i) {
            builder.insert(0, space);
            builder.append(space);
        }
        return builder.toString();
    }
}
