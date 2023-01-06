package me.zoxymodz.core.gui;

import com.gamingmesh.jobs.Jobs;
import me.zoxymodz.core.Core;
import me.zoxymodz.core.gui.f2w.F2wGUI;
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

public class MenuGUI implements Listener {

    private Core core;
    private static MenuGUI menuGUI;

    public MenuGUI(Core core) {
        this.core = core;
    }

    public Inventory invMenu(Player player){
        Inventory inv = Bukkit.createInventory(null,4*9,"» Menu principal");
        ItemStack orange = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 4).setName("vitre").toItemStack();
        ItemStack jaune = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 1).setName("vitre").toItemStack();
        inv.setItem(0, jaune);
        inv.setItem(1, jaune);
        inv.setItem(2, jaune);
        inv.setItem(6, orange);
        inv.setItem(7, orange);
        inv.setItem(8, orange);
        inv.setItem(9, jaune);
        inv.setItem(17, orange);
        inv.setItem(27, orange);
        inv.setItem(18,orange);
        inv.setItem(26,jaune);
        inv.setItem(27,orange);
        inv.setItem(28, orange);
        inv.setItem(29, orange);
        inv.setItem(33,jaune);
        inv.setItem(34,jaune);
        inv.setItem(35,jaune);

        inv.setItem(4,new ItemBuilder(Material.SKULL_ITEM,(short) 1).setSkullOwner(player.getName()).setName("§a§l✓ "+player.getName()).setLore("§6§l» §7Grade§8: §r "+core.getApi().getGroupManager().getGroup(core.getApi().getUserManager().getUser(player.getName()).getPrimaryGroup()).getCachedData().getMetaData().getPrefix(),"§6§l» §7Argent§8: §e"+ core.getEconomy().getBalance(player.getName())+"⛂","§6§l» §7Jobs§8: §a"+ Jobs.getPlayerManager().getJobsPlayer(player).getName()+"","").toItemStack());
        inv.setItem(11,new ItemBuilder(HeadList.BUSINESS.getItemStack()).setName("§a§l• §a§lBusiness").setLore("§Vous ne savez pas §acomment gagner","§ade l''argent §7? §7Nous vous expliquons tout.","","§7▸ §eCliquez pour y accéder","").toItemStack());
        inv.setItem(13, new ItemBuilder(HeadList.WARP.getItemStack()).setName("§b§l• §b§lWarps").setLore("§7Accédez aux §blieux §7les plus §bimportants §7du serveur.","§7(Outpost, Investissement, Évènements...)","","§7▸ §eCliquez pour y accéder","").toItemStack());
        inv.setItem(15,new ItemBuilder(HeadList.EVENT.getItemStack()).setName("§c§l• §c§lÉvénements").setLore("§7Soyez au courant des §choraires des événements §7du serveur.","§7(KoTH, Totem, Largages...)","","§7▸ §eCliquez pour y accéder").toItemStack());
        inv.setItem(21, new ItemBuilder(HeadList.BF2W.getItemStack()).setName("§e§l• §e§lBoutique §a§lFarm2Win ⛂").setLore("§7Profitez de §egrades, d''avantages, d''objets achetables","§7avec §al''argent ⛂ §7que vous gagnez sur le serveur !","","§7▸ §eCliquez pour y accéder","").toItemStack());
        inv.setItem(23, new ItemBuilder(HeadList.BVIP.getItemStack()).setName("§e§l• §e§lBoutique §b§lVIP ✪").setLore("§7Profitez de §egrades, d''avantages, d''objets achetables","§7avec vos §bPoints VIP ✪ §7!","","§7▸ §eCliquez pour y accéder","").toItemStack());
        inv.setItem(31,new ItemBuilder(HeadList.DISCORD.getItemStack()).setName("§9Discord").setLore("§7N'oubliez pas de rejoindre notre Discord","§7pour parler aux autres joueurs et pour","§7être au courant des dernières actualités du serveur!","","§7Discord: §9https://discord.gg/","").toItemStack());
        return inv;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equals("» Menu principal")){
            if (event.getClickedInventory() == null || event.getCurrentItem().getItemMeta()== null) return;
            event.setCancelled(true);
            switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                case "§e§l• §e§lBoutique §a§lFarm2Win ⛂":
                    player.openInventory(new F2wGUI(core).invF2w(player));
                    break;
                case "vitre":
                    break;
                default:
                    break;
            }
        }
    }

    public static MenuGUI getMenuGUI() {
        return menuGUI;
    }
}
