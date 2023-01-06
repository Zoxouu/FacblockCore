package me.zoxymodz.core.gui.f2w;

import me.zoxymodz.core.Core;
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

public class PointsFactionF2wGUI implements Listener {

    private Core core;

    public PointsFactionF2wGUI(Core core) {
        this.core = core;
    }

    public Inventory invPointsFaction() {
        Inventory inv = Bukkit.createInventory(null,3*9,"» Points Faction F2w");
        ItemStack jaune = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 4).setName("vitre").toItemStack();
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
        inv.setItem(4, new ItemBuilder(Material.PAPER).setName("§cAttention !").setLore("§7Si vous ne possédez pas de faction","§7les points achetés ne fonctionneront pas").toItemStack());
        inv.setItem(22,new ItemBuilder(HeadList.RETOUR.getItemStack()).setName("§cRetour").toItemStack());

        inv.setItem(11, new ItemBuilder(HeadList.COINS.getItemStack()).setName("§9§l• 1 Point Faction⛂").setLore("§7Prix: §a200,000⛂","§7Cliquez pour acheter.").toItemStack());
        inv.setItem(12, new ItemBuilder(HeadList.COINS.getItemStack()).setAmount(5).setName("§9§l• 5 Point Faction⛂").setLore("§7Prix: §a1,000,000⛂","§7Cliquez pour acheter.").toItemStack());
        inv.setItem(13, new ItemBuilder(HeadList.COINS.getItemStack()).setAmount(10).setName("§9§l• 10 Point Faction⛂").setLore("§7Prix: §a2,000,000⛂","§7Cliquez pour acheter.").toItemStack());
        inv.setItem(14, new ItemBuilder(HeadList.COINS.getItemStack()).setAmount(25).setName("§9§l• 25 Point Faction⛂").setLore("§7Prix: §a5,000,000⛂","§7Cliquez pour acheter.").toItemStack());
        inv.setItem(15, new ItemBuilder(HeadList.COINS.getItemStack()).setAmount(50).setName("§9§l• 50 Point Faction⛂").setLore("§7Prix: §a10,000,000⛂","§7Cliquez pour acheter.").toItemStack());

        return inv;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null || event.getCurrentItem().getItemMeta()== null) return;
        if (event.getInventory().getName().equals("» Points Faction F2w")) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                case "§9§l• 1 Point Faction⛂":
                    if (core.getEconomy().getBalance(player.getName()) < 200000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "classement "+player.getName()+" 1");
                    core.getEconomy().withdrawPlayer(player.getName(),200000);
                    player.sendMessage("§aVotre point ont bien été ajoutée");
                    player.closeInventory();
                    break;
                case "§9§l• 5 Point Faction⛂":
                    if (core.getEconomy().getBalance(player.getName()) < 1000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "classement "+player.getName()+" 5");
                    core.getEconomy().withdrawPlayer(player.getName(),1000000);
                    player.sendMessage("§aVos 5 points ont bien été ajoutée");
                    player.closeInventory();
                    break;
                case "§9§l• 10 Point Faction⛂":
                    if (core.getEconomy().getBalance(player.getName()) < 2000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "classement "+player.getName()+" 10");
                    core.getEconomy().withdrawPlayer(player.getName(),2000000);
                    player.sendMessage("§aVos 10 points ont bien été ajoutée");
                    player.closeInventory();
                    break;
                case "§9§l• 25 Point Faction⛂":
                    if (core.getEconomy().getBalance(player.getName()) < 5000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "classement "+player.getName()+" 25");
                    core.getEconomy().withdrawPlayer(player.getName(),5000000);
                    player.sendMessage("§aVos 25 points ont bien été ajoutée");
                    player.closeInventory();
                    break;
                case "§9§l• 50 Point Faction⛂":
                    if (core.getEconomy().getBalance(player.getName()) < 10000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "classement "+player.getName()+" 50");
                    core.getEconomy().withdrawPlayer(player.getName(),10000000);
                    player.sendMessage("§aVos 50 points ont bien été ajoutée");
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
