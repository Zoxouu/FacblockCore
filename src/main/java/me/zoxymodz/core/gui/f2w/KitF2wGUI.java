package me.zoxymodz.core.gui.f2w;

import me.zoxymodz.core.Core;
import me.zoxymodz.core.utils.HeadList;
import me.zoxymodz.core.utils.ItemBuilder;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class KitF2wGUI implements Listener {

    private Core core;

    public KitF2wGUI(Core core) {
        this.core = core;
    }

    public Inventory invKits(Player player) {
        Inventory inv = Bukkit.createInventory(null,3*9,"» Kits Farm2Win");
        User user = core.getApi().getUserManager().getUser(player.getName());
        Collection<Group> inheritedGroups = user.getInheritedGroups(user.getQueryOptions());
        ItemStack jaune = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 1).setName("vitre").toItemStack();
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

        inv.setItem(11,new ItemBuilder(Material.BOW).setName("§e• §6§lArcher").setLore("§7Description:","§7x§e2 arcs (Pucher II, Flame, Power III)","§7x§e64 Fleches","","§7Prix: §a350,000⛂","§7Cliquez pour acheter.").toItemStack());
        inv.setItem(13,new ItemBuilder(Material.TNT).setName("§e• §c§lPillage").setLore("§7Description:","§7x§e256 TNT","§7x§e64 Redstone","§7x§e64 Redstone Torche","§7x§e16 Redstone Repeater","§7x§e64 Piston","§7x§e4 Seau d'eau","","§7Prix: §a275,000⛂","§7Cliquez pour acheter.").toItemStack());
        inv.setItem(15,new ItemBuilder(Material.COMPASS).setName("§e• §d§lExploration").setLore("§7Description:","§7x§e4 Seau d'eau","§7x§e64 Perls","§7x§e64 Golden Apple","§7x§e64 Oak Wood","§7x§e32 ","§7x§e1 Compass","","§7Prix: §a125,000⛂","§7Cliquez pour acheter.").toItemStack());

        if (inheritedGroups.stream().anyMatch(g -> g.getName().equals("archer"))) inv.setItem(11,new ItemBuilder(Material.BOW).setName("§e• §6§lArcher").setLore("§aVous avez déjà acheté ce kit !","§7Description:","§7x§e2 arcs (Pucher II, Flame, Power III)","§7x§e64 Fleches","","§7Prix: §a350,000⛂","§7Cliquez pour acheter.").toItemStack());
        if (inheritedGroups.stream().anyMatch(g -> g.getName().equals("pillage"))) inv.setItem(13,new ItemBuilder(Material.TNT).setName("§e• §c§lPillage").setLore("§aVous avez déjà acheté ce kit !","§7Description:","§7x§e256 TNT","§7x§e64 Redstone","§7x§e64 Redstone Torche","§7x§e16 Redstone Repeater","§7x§e64 Piston","§7x§e4 Seau d'eau","","§7Prix: §a275,000⛂","§7Cliquez pour acheter.").toItemStack());
        if (inheritedGroups.stream().anyMatch(g -> g.getName().equals("exploration")))  inv.setItem(15,new ItemBuilder(Material.COMPASS).setName("§e• §d§lExploration").setLore("§aVous avez déjà acheté ce kit !","§7Description:","§7x§e4 Seau d'eau","§7x§e64 Perls","§7x§e64 Golden Apple","§7x§e64 Oak Wood","§7x§e32 ","§7x§e1 Compass","","§7Prix: §a125,000⛂","§7Cliquez pour acheter.").toItemStack());
        return inv;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        User user = core.getApi().getUserManager().getUser(player.getName());
        Collection<Group> inheritedGroups = user.getInheritedGroups(user.getQueryOptions());
        if (event.getClickedInventory() == null || event.getCurrentItem().getItemMeta()== null) return;
        if (event.getInventory().getName().equals("» Kits Farm2Win")){
            event.setCancelled(true);
            switch (event.getCurrentItem().getItemMeta().getDisplayName()){
                case "§e• §6§lArcher":
                    if (inheritedGroups.stream().anyMatch(g -> g.getName().equals("archer"))) {
                        player.sendMessage("§cVous possedé deja ce kit !");
                        return;
                    }
                    if (core.getEconomy().getBalance(player.getName()) < 350000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user "+player.getName()+" parent add archer");
                    core.getEconomy().withdrawPlayer(player.getName(),350000);
                    player.closeInventory();
                    break;
                case "§e• §c§lPillage":
                    if (inheritedGroups.stream().anyMatch(g -> g.getName().equals("pillage"))) {
                        player.sendMessage("§cVous possedé deja ce kit !");
                        return;
                    }
                    if (core.getEconomy().getBalance(player.getName()) < 275000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user "+player.getName()+" parent add pillage");
                    core.getEconomy().withdrawPlayer(player.getName(),275000);
                    player.closeInventory();
                    break;
                case "§e• §d§lExploration":
                    if (inheritedGroups.stream().anyMatch(g -> g.getName().equals("exploration"))) {
                        player.sendMessage("§cVous possedé deja ce kit !");
                        return;
                    }
                    if (core.getEconomy().getBalance(player.getName()) < 125000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user "+player.getName()+" parent add exploration");
                    core.getEconomy().withdrawPlayer(player.getName(),125000);
                    player.closeInventory();
                    break;
                case "vitre":
                    break;
                case "§cRetour":
                    player.openInventory(new F2wGUI(core).invF2w(player));
                    break;
                default:
                    break;
            }
        }
    }
}
