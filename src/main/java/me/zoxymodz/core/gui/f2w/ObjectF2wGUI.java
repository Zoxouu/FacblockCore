package me.zoxymodz.core.gui.f2w;

import me.zoxymodz.core.Core;
import me.zoxymodz.core.utils.HeadList;
import me.zoxymodz.core.utils.ItemBuilder;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ObjectF2wGUI implements Listener {

    private Core core;
    public ObjectF2wGUI(Core core) {
        this.core = core;
    }

    public Inventory invObject(Player player) {
        Inventory inv = Bukkit.createInventory(null,3*9,"» Objets Farm2Win");
        ItemStack jaune = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 10).setName("vitre").toItemStack();
        inv.setItem(0, jaune);
        inv.setItem(1, jaune);
        inv.setItem(2, jaune);
        inv.setItem(3, jaune);
        inv.setItem(4, jaune);
        inv.setItem(5, jaune);
        inv.setItem(6, jaune);
        inv.setItem(7, jaune);
        inv.setItem(8, jaune);
        inv.setItem(9, jaune);
        inv.setItem(17, jaune);
        inv.setItem(18, jaune);
        inv.setItem(19, jaune);
        inv.setItem(20, jaune);
        inv.setItem(21, jaune);
        inv.setItem(23, jaune);
        inv.setItem(24, jaune);
        inv.setItem(25, jaune);
        inv.setItem(26, jaune);
        inv.setItem(22,new ItemBuilder(HeadList.RETOUR.getItemStack()).setName("§cRetour").toItemStack());


        inv.setItem(11, new ItemBuilder(Material.ENDER_PORTAL_FRAME).setName("§e✴ §a§lChunk Buster §e✴").addEnchant(Enchantment.DAMAGE_ALL, 1).removeFlags().setLore("§7Détruisez la §etotalité des blocs","§ed''un chunk §7en posant ce bloc !","","§7Prix: §a3,000,000⛂","§7Cliquez pour acheter.").toItemStack());
        inv.setItem(13, new ItemBuilder(Material.OBSIDIAN).addEnchant(Enchantment.DAMAGE_ALL, 1).setName("§d§l• Genbucket Obsidienne").setLore("§7Posez ce bloc et §eil construira une ligne de","§eblocs d''Obsidienne §7dans la direction posée !","","§7Prix: §a500,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
        inv.setItem(15, new ItemBuilder(Material.BARRIER).setName("§aA venir").addEnchant(Enchantment.DAMAGE_ALL, 1).removeFlags().setLore("§eFaites vos proposition sur le discord").toItemStack());

        return inv;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null || event.getCurrentItem().getItemMeta()== null) return;
        if (event.getInventory().getName().equals("» Objets Farm2Win")){
            event.setCancelled(true);
            switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                case "§e✴ §a§lChunk Buster §e✴":
                    if (core.getEconomy().getBalance(player.getName()) < 3000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "chunkbuster give "+player.getName()+" 1");
                    core.getEconomy().withdrawPlayer(player.getName(),3000000);
                    player.closeInventory();
                    break;
                case "§d§l• Genbucket Obsidienne":
                    if (core.getEconomy().getBalance(player.getName()) < 500000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    core.getEconomy().withdrawPlayer(player.getName(),500000);
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "gba give "+player.getName()+" obsi 1");
                    player.closeInventory();
                    break;
                case "§cRetour":
                    player.openInventory(new F2wGUI(core).invF2w(player));
                    break;
                case "vitre":
                    break;
                default:
                    break;
            }
        }
    }
}
