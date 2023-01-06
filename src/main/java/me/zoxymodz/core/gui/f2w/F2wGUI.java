package me.zoxymodz.core.gui.f2w;

import me.zoxymodz.core.Core;
import me.zoxymodz.core.gui.MenuGUI;
import me.zoxymodz.core.utils.HeadList;
import me.zoxymodz.core.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class F2wGUI implements Listener {
    private Core core;

    public F2wGUI(Core core) {
        this.core = core;
    }

    public Inventory invF2w(Player player) {
        Inventory inv = Bukkit.createInventory(null,5*9,"» Menu F2w");
        ItemStack orange = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 4).setName("vitre").toItemStack();
        ItemStack jaune = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 1).setName("vitre").toItemStack();
        inv.setItem(0, jaune);
        inv.setItem(1, jaune);
        inv.setItem(7, orange);
        inv.setItem(8, orange);
        inv.setItem(9, jaune);
        inv.setItem(17, orange);
        inv.setItem(27, orange);
        inv.setItem(35, jaune);
        inv.setItem(36, orange);
        inv.setItem(37, orange);
        inv.setItem(43, jaune);
        inv.setItem(44, jaune);
        inv.setItem(40, new ItemBuilder(HeadList.RETOUR.getItemStack()).setName("§cRetour").removeFlags().toItemStack());
        inv.setItem(20, new ItemBuilder(HeadList.GRADE.getItemStack()).setName("§b§l• §b§lGrades").setLore("§7Tu peux acheter tes grades avec l''§bargent ⛂ §7du jeu !","","§7▸ §eCliquez pour y accéder","").toItemStack());
        inv.setItem(21,new ItemBuilder(HeadList.ATOUTS.getItemStack()).setName("§a§l• §a§lAtouts").setLore("§7Des avantages qui te rendent plus §apuissant §7!","§7(Vitesse, Boost de vie...)!","","§7▸ §eCliquez pour y accéder","").toItemStack());
        inv.setItem(22,new ItemBuilder(HeadList.RUBIS.getItemStack()).setName("§4§l• §4§lKits").setLore("§7Acquit de nombreux kits","§7avec l'§4argent ⛂ §7du jeu !","","§7▸ §eCliquez pour y accéder","").toItemStack());
        inv.setItem(23, new ItemBuilder(HeadList.OBJECT.getItemStack()).setName("§c§l• §c§lObjets").setLore("§7Ces objets vous seront §cindispensables.","§7pour devenir le §cmeilleur§7.","","§7▸ §eCliquez pour y accéder","").toItemStack());
        inv.setItem(24, new ItemBuilder(HeadList.COINS.getItemStack()).setName("§9§l• Points Faction").setAmount(1).setLore("§7Achète des §7points faction","§7pour devenir §ela faction la plus forte!","","§7▸ §eCliquez pour y accéder","").toItemStack());
        return inv;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null || event.getCurrentItem().getItemMeta()== null) return;
        if (event.getInventory().getName().equals("» Menu F2w")) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getItemMeta().getDisplayName()){
                case "§b§l• §b§lGrades":
                    player.openInventory(new GradeF2wGUI(core).invRank(player));
                    break;
                case "§a§l• §a§lAtouts":
                    player.openInventory(new AtoutsF2wGUI(core).invAtouts(player));
                    break;
                case "§4§l• §4§lKits":
                    player.openInventory(new KitF2wGUI(core).invKits(player));
                    break;
                case "§c§l• §c§lObjets":
                    player.openInventory(new ObjectF2wGUI(core).invObject(player));
                    break;
                case "§9§l• Points Faction":
                    player.openInventory(new PointsFactionF2wGUI(core).invPointsFaction());
                    break;
                case "vitre":
                    break;
                case "§cRetour":
                    player.openInventory(new MenuGUI(core).invMenu(player));
                    break;
                default:
                    break;
            }
        }
    }
}
