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

public class GradeF2wGUI implements Listener {

    private Core core;
    private static GradeF2wGUI gradeF2wGUI;

    public GradeF2wGUI(Core core) {
        this.core = core;
    }

    public Inventory invRank(Player player){
        Inventory inv = Bukkit.getServer().createInventory(null,5*9,"» Grade Farm2Win");
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

        switch (core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()){
            case "vip":
                inv.setItem(14, new ItemBuilder(HeadList.VIP.getItemStack()).setName("§e• VIP").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 32 Solidité 20 Tranchant 35","§6▸ §e12x /sethome","§6▸ ","§6▸ §e/pv §7- 10 Coffre privé","§6▸ §e20 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(20, new ItemBuilder(HeadList.LENGENDAIRE.getItemStack()).setName("§b• Legendaire").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 17 Solidité 5 Tranchant 17","§6▸ §e3x /sethome","§6▸ §e/pv §7- 1 Coffre privé","§6▸ §e5 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(21, new ItemBuilder(HeadList.MAITRE.getItemStack()).setName("§9• Maitre").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 18 Solidité 6 Tranchant 19","§6▸ §e/back","§6▸ §e5x /sethome","§6▸ §e/pv §7- 2 Coffre privé","§6▸ §e7 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(22, new ItemBuilder(HeadList.SEIGNEUR.getItemStack()).setName("§2• Seigneur").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 20 Solidité 7 Tranchant 21","§6▸ §e/near","§6▸ §e7x /sethome","§6▸ §e/pv §7- 3 Coffre privé","§6▸ §e9 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(23, new ItemBuilder(HeadList.ROI.getItemStack()).setName("§6• Roi").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 22 Solidité 8 Tranchant 23","§6▸ §e/condense","§6▸ §e9x /sethome","§6▸ §e/pv 1 §7- 4 Coffre privé","§6▸ §e11 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(24, new ItemBuilder(HeadList.DEMON.getItemStack()).setName("§4• Demon").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 26 Solidité 9 Tranchant 26","§6▸ §e/feed","§6▸ §e12x /sethome","§6▸ §e/pv §7- 5 Coffre privé","§6▸ §e14 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(12, new ItemBuilder(HeadList.CHAMPION.getItemStack()).setName("§d• Champion").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 27 Solidité 12 Tranchant 28","§6▸ §e/repair","§6▸ §e15x /sethome","§6▸ §e/pv §7- 6 Coffre privé","§6▸ §e15 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                break;
            case "champion":
                inv.setItem(14, new ItemBuilder(HeadList.VIP.getItemStack()).setName("§e• VIP").setLore("§6▸ §eKit Protection 32 Solidité 20 Tranchant 35","6▸ §e12x /sethome","§6▸ ","§6▸ §e/pv §7- 10 Coffre privé","§6▸ §e20 objets §7simultanés à l''HDV","","§7Prix: §a100,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(20, new ItemBuilder(HeadList.LENGENDAIRE.getItemStack()).setName("§b• Legendaire").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 17 Solidité 5 Tranchant 17","§6▸ §e3x /sethome","§6▸ §e/pv §7- 1 Coffre privé","§6▸ §e5 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(21, new ItemBuilder(HeadList.MAITRE.getItemStack()).setName("§9• Maitre").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 18 Solidité 6 Tranchant 19","§6▸ §e/back","§6▸ §e5x /sethome","§6▸ §e/pv §7- 2 Coffre privé","§6▸ §e7 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(22, new ItemBuilder(HeadList.SEIGNEUR.getItemStack()).setName("§2• Seigneur").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 20 Solidité 7 Tranchant 21","§6▸ §e/near","§6▸ §e7x /sethome","§6▸ §e/pv §7- 3 Coffre privé","§6▸ §e9 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(23, new ItemBuilder(HeadList.ROI.getItemStack()).setName("§6• Roi").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 22 Solidité 8 Tranchant 23","§6▸ §e/condense","§6▸ §e9x /sethome","§6▸ §e/pv 1 §7- 4 Coffre privé","§6▸ §e11 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(24, new ItemBuilder(HeadList.DEMON.getItemStack()).setName("§4• Demon").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 26 Solidité 9 Tranchant 26","§6▸ §e/feed","§6▸ §e12x /sethome","§6▸ §e/pv §7- 5 Coffre privé","§6▸ §e14 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(12, new ItemBuilder(HeadList.CHAMPION.getItemStack()).setName("§d• Champion").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 27 Solidité 12 Tranchant 28","§6▸ §e/repair","§6▸ §e15x /sethome","§6▸ §e/pv §7- 6 Coffre privé","§6▸ §e15 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                break;
            case "demon":
                inv.setItem(14, new ItemBuilder(HeadList.VIP.getItemStack()).setName("§e• VIP").setLore("§6▸ §eKit Protection 32 Solidité 20 Tranchant 35","§6▸ §e12x /sethome","§6▸ §e/nick","§6▸ §eChatColor (avec &)","§6▸ §e/pv §7- 10 Coffre privé","§6▸ §e20 objets §7simultanés à l''HDV","","§7Prix: §a100,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(20, new ItemBuilder(HeadList.LENGENDAIRE.getItemStack()).setName("§b• Legendaire").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 17 Solidité 5 Tranchant 17","§6▸ §e3x /sethome","§6▸ §e/pv §7- 1 Coffre privé","§6▸ §e5 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(21, new ItemBuilder(HeadList.MAITRE.getItemStack()).setName("§9• Maitre").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 18 Solidité 6 Tranchant 19","§6▸ §e/back","§6▸ §e5x /sethome","§6▸ §e/pv §7- 2 Coffre privé","§6▸ §e7 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(22, new ItemBuilder(HeadList.SEIGNEUR.getItemStack()).setName("§2• Seigneur").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 20 Solidité 7 Tranchant 21","§6▸ §e/near","§6▸ §e7x /sethome","§6▸ §e/pv §7- 3 Coffre privé","§6▸ §e9 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(23, new ItemBuilder(HeadList.ROI.getItemStack()).setName("§6• Roi").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 22 Solidité 8 Tranchant 23","§6▸ §e/condense","§6▸ §e9x /sethome","§6▸ §e/pv 1 §7- 4 Coffre privé","","§6▸ §e11 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(24, new ItemBuilder(HeadList.DEMON.getItemStack()).setName("§4• Demon").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 26 Solidité 9 Tranchant 26","§6▸ §e/feed","§6▸ §e12x /sethome","§6▸ §e/pv §7- 5 Coffre privé","§6▸ §e14 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(12, new ItemBuilder(HeadList.CHAMPION.getItemStack()).setName("§d• Champion").setLore("§6▸ §eKit Protection 27 Solidité 12 Tranchant 28","§6▸ §e/repair","§6▸ §e15x /sethome","§6▸ §e/pv §7- 6 Coffre privé","§6▸ §e15 objets §7simultanés à l''HDV","","§7Prix: §a80,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                break;
            case "roi":
                inv.setItem(14, new ItemBuilder(HeadList.VIP.getItemStack()).setName("§e• VIP").setLore("§6▸ §eKit Protection 32 Solidité 20 Tranchant 35","§6▸ §e12x /sethome","§6▸ §e/nick","§6▸ §eChatColor (avec &)","§6▸ §e/pv §7- 10 Coffre privé","§6▸ §e20 objets §7simultanés à l''HDV","","§7Prix: §a100,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(20, new ItemBuilder(HeadList.LENGENDAIRE.getItemStack()).setName("§b• Legendaire").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 17 Solidité 5 Tranchant 17","§6▸ §e3x /sethome","§6▸ §e/pv §7- 1 Coffre privé","§6▸ §e5 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(21, new ItemBuilder(HeadList.MAITRE.getItemStack()).setName("§9• Maitre").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 18 Solidité 6 Tranchant 19","§6▸ §e/back","§6▸ §e5x /sethome","§6▸ §e/pv §7- 2 Coffre privé","§6▸ §e7 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(22, new ItemBuilder(HeadList.SEIGNEUR.getItemStack()).setName("§2• Seigneur").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 20 Solidité 7 Tranchant 21","§6▸ §e/near","§6▸ §e7x /sethome","§6▸ §e/pv §7- 3 Coffre privé","§6▸ §e9 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(23, new ItemBuilder(HeadList.ROI.getItemStack()).setName("§6• Roi").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 22 Solidité 8 Tranchant 23","§6▸ §e/condense","§6▸ §e9x /sethome","§6▸ §e/pv 1 §7- 4 Coffre privé","","§6▸ §e11 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(24, new ItemBuilder(HeadList.DEMON.getItemStack()).setName("§4• Demon").setLore("§6▸ §eKit Protection 26 Solidité 9 Tranchant 26","§6▸ §e/feed","§6▸ §e12x /sethome","§6▸ §e/pv §7- 5 Coffre privé","§6▸ §e14 objets §7simultanés à l''HDV","","§7Prix: §a50,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(12, new ItemBuilder(HeadList.CHAMPION.getItemStack()).setName("§d• Champion").setLore("§6▸ §eKit Protection 27 Solidité 12 Tranchant 28","§6▸ §e/repair","§6▸ §e15x /sethome","§6▸ §e/pv §7- 6 Coffre privé","§6▸ §e15 objets §7simultanés à l''HDV","","§7Prix: §a80,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                break;
            case "segneur":
                inv.setItem(14, new ItemBuilder(HeadList.VIP.getItemStack()).setName("§e• VIP").setLore("§6▸ §eKit Protection 32 Solidité 20 Tranchant 35","§6▸ §e12x /sethome","§6▸ §e/nick","§6▸ §eChatColor (avec &)","§6▸ §e/pv §7- 10 Coffre privé","§6▸ §e20 objets §7simultanés à l''HDV","","§7Prix: §a100,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(20, new ItemBuilder(HeadList.LENGENDAIRE.getItemStack()).setName("§b• Legendaire").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 17 Solidité 5 Tranchant 17","§6▸ §e3x /sethome","§6▸ §e/pv §7- 1 Coffre privé","§6▸ §e5 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(21, new ItemBuilder(HeadList.MAITRE.getItemStack()).setName("§9• Maitre").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 18 Solidité 6 Tranchant 19","§6▸ §e/back","§6▸ §e5x /sethome","§6▸ §e/pv §7- 2 Coffre privé","§6▸ §e7 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(22, new ItemBuilder(HeadList.SEIGNEUR.getItemStack()).setName("§2• Seigneur").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 20 Solidité 7 Tranchant 21","§6▸ §e/near","§6▸ §e7x /sethome","§6▸ §e/pv §7- 3 Coffre privé","§6▸ §e9 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(23, new ItemBuilder(HeadList.ROI.getItemStack()).setName("§6• Roi").setLore("§6▸ §eKit Protection 22 Solidité 8 Tranchant 23","§6▸ §e/condense","§6▸ §e9x /sethome","§6▸ §e/pv 1 §7- 4 Coffre privé","§6▸ §e11 objets §7simultanés à l''HDV","","§7Prix: §a25,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(24, new ItemBuilder(HeadList.DEMON.getItemStack()).setName("§4• Demon").setLore("§6▸ §eKit Protection 26 Solidité 9 Tranchant 26","§6▸ §e/feed","§6▸ §e12x /sethome","§6▸ §e/pv §7- 5 Coffre privé","§6▸ §e14 objets §7simultanés à l''HDV","","§7Prix: §a50,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(12, new ItemBuilder(HeadList.CHAMPION.getItemStack()).setName("§d• Champion").setLore("§6▸ §eKit Protection 27 Solidité 12 Tranchant 28","§6▸ §e/repair","§6▸ §e15x /sethome","§6▸ §e/pv §7- 6 Coffre privé","§6▸ §e15 objets §7simultanés à l''HDV","","§7Prix: §a80,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                break;
            case "maitre":
                inv.setItem(14, new ItemBuilder(HeadList.VIP.getItemStack()).setName("§e• VIP").setLore("§6▸ §eKit Protection 32 Solidité 20 Tranchant 35","§6▸ §e12x /sethome","§6▸ §e/nick","§6▸ §eChatColor (avec &)","§6▸ §e/pv §7- 10 Coffre privé","§6▸ §e20 objets §7simultanés à l''HDV","","§7Prix: §a100,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(20, new ItemBuilder(HeadList.LENGENDAIRE.getItemStack()).setName("§b• Legendaire").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 17 Solidité 5 Tranchant 17","§6▸ §e3x /sethome","§6▸ §e/pv §7- 1 Coffre privé","§6▸ §e5 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(21, new ItemBuilder(HeadList.MAITRE.getItemStack()).setName("§9• Maitre").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 18 Solidité 6 Tranchant 19","§6▸ §e/back","§6▸ §e5x /sethome","§6▸ §e/pv §7- 2 Coffre privé","§6▸ §e7 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(22, new ItemBuilder(HeadList.SEIGNEUR.getItemStack()).setName("§2• Seigneur").setLore("§6▸ §eKit Protection 20 Solidité 7 Tranchant 21","§6▸ §e/invsee","§6▸ §e7x /sethome","§6▸ §e/pv §7- 3 Coffre privé","§6▸ §e9 objets §7simultanés à l''HDV","","§7Prix: §a12,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(23, new ItemBuilder(HeadList.ROI.getItemStack()).setName("§6• Roi").setLore("§6▸ §eKit Protection 22 Solidité 8 Tranchant 23","§6▸ §e/condense","§6▸ §e9x /sethome","§6▸ §e/pv 1 §7- 4 Coffre privé","§6▸ §e11 objets §7simultanés à l''HDV","","§7Prix: §a25,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(24, new ItemBuilder(HeadList.DEMON.getItemStack()).setName("§4• Demon").setLore("§6▸ §eKit Protection 26 Solidité 9 Tranchant 26","§6▸ §e/feed","§6▸ §e12x /sethome","§6▸ §e/pv §7- 5 Coffre privé","§6▸ §e14 objets §7simultanés à l''HDV","","§7Prix: §a50,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(12, new ItemBuilder(HeadList.CHAMPION.getItemStack()).setName("§d• Champion").setLore("§6▸ §eKit Protection 27 Solidité 12 Tranchant 28","§6▸ §e/repair","§6▸ §e15x /sethome","§6▸ §e/pv §7- 6 Coffre privé","§6▸ §e15 objets §7simultanés à l''HDV","","§7Prix: §a80,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                break;
            case "legendaire":
                inv.setItem(14, new ItemBuilder(HeadList.VIP.getItemStack()).setName("§e• VIP").setLore("§6▸ §eKit Protection 32 Solidité 20 Tranchant 35","§6▸ §e12x /sethome","§6▸ §e/nick","§6▸ §eChatColor (avec &)","§6▸ §e/pv §7- 10 Coffre privé","§6▸ §e20 objets §7simultanés à l''HDV","","§7Prix: §a100,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(20, new ItemBuilder(HeadList.LENGENDAIRE.getItemStack()).setName("§b• Legendaire").setLore("§aVous avez déjà acheté ce grade !","§6▸ §eKit Protection 17 Solidité 5 Tranchant 17","§6▸ §e3x /sethome","§6▸ §e/pv §7- 1 Coffre privé","§6▸ §e5 objets §7simultanés à l''HDV").removeFlags().toItemStack());
                inv.setItem(21, new ItemBuilder(HeadList.MAITRE.getItemStack()).setName("§9• Maitre").setLore("§6▸ §eKit Protection 18 Solidité 6 Tranchant 19","§6▸ §e/back","§6▸ §e5x /sethome","§6▸ §e/pv §7- 2 Coffre privé","§6▸ §e7 objets §7simultanés à l''HDV","","§7Prix: §a8,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(22, new ItemBuilder(HeadList.SEIGNEUR.getItemStack()).setName("§2• Seigneur").setLore("§6▸ §eKit Protection 20 Solidité 7 Tranchant 21","§6▸ §e/invsee","§6▸ §e7x /sethome","§6▸ §e/pv §7- 3 Coffre privé","§6▸ §e9 objets §7simultanés à l''HDV","","§7Prix: §a12,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(23, new ItemBuilder(HeadList.ROI.getItemStack()).setName("§6• Roi").setLore("§6▸ §eKit Protection 22 Solidité 8 Tranchant 23","§6▸ §e/condense","§6▸ §e9x /sethome","§6▸ §e/pv 1 §7- 4 Coffre privé","§6▸ §e11 objets §7simultanés à l''HDV","","§7Prix: §a25,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(24, new ItemBuilder(HeadList.DEMON.getItemStack()).setName("§4• Demon").setLore("§6▸ §eKit Protection 26 Solidité 9 Tranchant 26","§6▸ §e/feed","§6▸ §e12x /sethome","§6▸ §e/pv §7- 5 Coffre privé","§6▸ §e14 objets §7simultanés à l''HDV","","§7Prix: §a50,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(12, new ItemBuilder(HeadList.CHAMPION.getItemStack()).setName("§d• Champion").setLore("§6▸ §eKit Protection 27 Solidité 12 Tranchant 28","§6▸ §e/repair","§6▸ §e15x /sethome","§6▸ §e/pv §7- 6 Coffre privé","§6▸ §e15 objets §7simultanés à l''HDV","","§7Prix: §a80,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                break;
            default:
                inv.setItem(14, new ItemBuilder(HeadList.VIP.getItemStack()).setName("§e• VIP").setLore("§6▸ §eKit Protection 32 Solidité 20 Tranchant 35","§6▸ §e12x /sethome","§6▸ §e/nick","§6▸ §eChatColor (avec &)","§6▸ §e/pv §7- 10 Coffre privé","§6▸ §e20 objets §7simultanés à l''HDV","","§7Prix: §a100,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(20, new ItemBuilder(HeadList.LENGENDAIRE.getItemStack()).setName("§b• Legendaire").setLore("§6▸ §eKit Protection 17 Solidité 5 Tranchant 17","§6▸ §e/near","§6▸ §e3x /sethome","§6▸ §e/pv §7- 1 Coffre privé","§6▸ §e5 objets §7simultanés à l''HDV","","§7Prix: §a2,500,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(21, new ItemBuilder(HeadList.MAITRE.getItemStack()).setName("§9• Maitre").setLore("§6▸ §eKit Protection 18 Solidité 6 Tranchant 19","§6▸ §e/back","§6▸ §e5x /sethome","§6▸ §e/pv §7- 2 Coffre privé","§6▸ §e7 objets §7simultanés à l''HDV","","§7Prix: §a8,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(22, new ItemBuilder(HeadList.SEIGNEUR.getItemStack()).setName("§2• Seigneur").setLore("§6▸ §eKit Protection 20 Solidité 7 Tranchant 21","§6▸ §e/invsee","§6▸ §e7x /sethome","§6▸ §e/pv §7- 3 Coffre privé","§6▸ §e9 objets §7simultanés à l''HDV","","§7Prix: §a12,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(23, new ItemBuilder(HeadList.ROI.getItemStack()).setName("§6• Roi").setLore("§6▸ §eKit Protection 22 Solidité 8 Tranchant 23","§6▸ §e/condense","§6▸ §e9x /sethome","§6▸ §e/pv 1 §7- 4 Coffre privé","§6▸ §e11 objets §7simultanés à l''HDV","","§7Prix: §a25,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(24, new ItemBuilder(HeadList.DEMON.getItemStack()).setName("§4• Demon").setLore("§6▸ §eKit Protection 26 Solidité 9 Tranchant 26","§6▸ §e/feed","§6▸ §e12x /sethome","§6▸ §e/pv §7- 5 Coffre privé","§6▸ §e14 objets §7simultanés à l''HDV","","§7Prix: §a50,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                inv.setItem(12, new ItemBuilder(HeadList.CHAMPION.getItemStack()).setName("§d• Champion").setLore("§6▸ §eKit Protection 27 Solidité 12 Tranchant 28","§6▸ §e/repair","§6▸ §e15x /sethome","§6▸ §e/pv §7- 6 Coffre privé","§6▸ §e15 objets §7simultanés à l''HDV","","§7Prix: §a80,000,000⛂","§7Cliquez pour acheter.").removeFlags().toItemStack());
                break;
        }
        return inv;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null || event.getCurrentItem().getItemMeta()== null) return;
        if (event.getInventory().getName().equals("» Grade Farm2Win")){
            event.setCancelled(true);
            switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                case "§e• VIP":
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() > 30)return;
                    if (core.getEconomy().getBalance(player.getName()) < 100000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() != 30) {
                        player.sendMessage("§cVous devez etre §dChampion §cpour acheter ce grade !");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user "+player.getName()+" parent add vip");
                    core.getEconomy().withdrawPlayer(player.getName(),100000000);
                    player.closeInventory();
                    break;
                case "§d• Champion":
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() > 25)return;
                    if (core.getEconomy().getBalance(player.getName()) < 80000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() != 25) {
                        player.sendMessage("§cVous devez etre §4Demon §cpour acheter ce grade !");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user "+player.getName()+" parent add champion");
                    core.getEconomy().withdrawPlayer(player.getName(),80000000);
                    player.closeInventory();
                    break;
                case "§4• Demon":
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() > 20) return;
                    if (core.getEconomy().getBalance(player.getName()) < 50000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() != 20) {
                        player.sendMessage("§cVous devez etre §6Roi §cpour acheter ce grade !");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user "+player.getName()+" parent add demon");
                    core.getEconomy().withdrawPlayer(player.getName(),50000000);
                    player.closeInventory();
                    break;
                case "§6• Roi":
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() > 15) return;
                    if (core.getEconomy().getBalance(player.getName()) < 25000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() != 15) {
                        player.sendMessage("§cVous devez etre §2Seigneur §cpour acheter ce grade !");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user "+player.getName()+" parent add roi");
                    core.getEconomy().withdrawPlayer(player.getName(),25000000);
                    player.closeInventory();
                    break;
                case "§2• Seigneur":
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() > 10) return;
                    if (core.getEconomy().getBalance(player.getName()) < 12000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() != 10) {
                        player.sendMessage("§cVous devez etre §9Maitre §cpour acheter ce grade !");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user "+player.getName()+" parent add segneur");
                    core.getEconomy().withdrawPlayer(player.getName(),12000000);
                    player.closeInventory();
                    break;
                case "§9• Maitre":
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() > 5) return;
                    if (core.getEconomy().getBalance(player.getName()) < 8000000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() != 5) {
                        player.sendMessage("§cVous devez etre §bLegendaire §cpour acheter ce grade !");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user "+player.getName()+" parent add maitre");
                    core.getEconomy().withdrawPlayer(player.getName(),8000000);
                    player.closeInventory();
                    break;
                case "§b• Legendaire":
                    if (core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getWeight().getAsInt() > 0) return;
                    if (core.getEconomy().getBalance(player.getName()) < 2500000) {
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        player.closeInventory();
                        return;
                    }
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user "+player.getName()+" parent add legendaire");
                    core.getEconomy().withdrawPlayer(player.getName(),2500000);
                    player.closeInventory();
                    break;
                case"vitre":
                    break;
                case "§cRetour":
                    player.openInventory(new F2wGUI(core).invF2w(player));
                    break;
                default:
                    break;
            }
        }
    }

    public static GradeF2wGUI getGradeF2wGUI() {
        return gradeF2wGUI;
    }
}
