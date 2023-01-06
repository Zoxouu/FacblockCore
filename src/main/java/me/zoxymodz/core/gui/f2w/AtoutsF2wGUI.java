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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AtoutsF2wGUI implements Listener {

    private Core core;

    public AtoutsF2wGUI(Core core) {
        this.core = core;
    }

    public Inventory invAtouts(Player player){
        Inventory inv = Bukkit.createInventory(null,5*9,"» Atouts");
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
        inv.setItem(20, new ItemBuilder(HeadList.COEURS.getItemStack()).setName("§e§l• 10 coeurs supplémentaires").setLore("§eObtenez 10§c♥ §esupplémentaires","§7(L''effet se dissipe quand vous mourrez.)","§7Prix: §a750,000⛂","§7Cliquez pour acheter.","").toItemStack());
        inv.setItem(21, new ItemBuilder(HeadList.SPEED.getItemStack()).setName("§e§l• Speed III").setLore("§eObtenez l''efffet §lSpeed II","§7(L''effet se dissipe quand vous mourrez.)","","§7Prix: §a450,000⛂","§7Cliquez pour acheter.").toItemStack());
        inv.setItem(22, new ItemBuilder(HeadList.INVISIBILITE.getItemStack()).setName("§e§l• Invisibilité").setLore("§eObtenez l''efffet §lInvisibilité","§7(L''effet se dissipe quand vous mourrez.)","","§7Prix: §a250,000⛂","§7Cliquez pour acheter.").toItemStack());
        inv.setItem(23, new ItemBuilder(HeadList.RESISTANCE.getItemStack()).setName("§e§l• Resistance II").setLore("§eObtenez l''efffet §lResistance II","§7Réduction de §e40% §7des dégâts","§7(L''effet se dissipe quand vous mourrez.)","","§7Prix: §a5,000,000⛂","§7Cliquez pour acheter.").toItemStack());
        inv.setItem(24, new ItemBuilder(HeadList.HASTE.getItemStack()).setName("§e§l• Haste III").setLore("§eObtenez l''efffet §lHaste III","§7(L''effet se dissipe quand vous mourrez.)","","§7Prix: §a550,000⛂","§7Cliquez pour acheter.").toItemStack());
        if (player.getActivePotionEffects().stream().anyMatch(potionEffect -> potionEffect.getType().equals(PotionEffectType.HEALTH_BOOST) && potionEffect.getAmplifier() == 4)) {
            inv.setItem(20, new ItemBuilder(HeadList.COEURS.getItemStack()).setName("§e§l• 10 coeurs supplémentaires").setLore("§aVous avez déjà acheté cette effect !","§eObtenez 10§c♥ §esupplémentaires","§7(L''effet se dissipe quand vous mourrez.)","§7Prix: §a750,000⛂","§7Cliquez pour acheter.","").toItemStack());
        }
        if (player.getActivePotionEffects().stream().anyMatch(potionEffect -> potionEffect.getType().equals(PotionEffectType.SPEED) && potionEffect.getAmplifier() == 2)) inv.setItem(21, new ItemBuilder(HeadList.SPEED.getItemStack()).setName("§e§l• Speed III").setLore("§aVous avez déjà acheté cette effect !","§eObtenez l''efffet §lSpeed III","§7(L''effet se dissipe quand vous mourrez.)","","§7Prix: §a450,000⛂","§7Cliquez pour acheter.").toItemStack());
        if (player.getActivePotionEffects().stream().anyMatch(potionEffect -> potionEffect.getType().equals(PotionEffectType.INVISIBILITY))) inv.setItem(22, new ItemBuilder(HeadList.INVISIBILITE.getItemStack()).setName("§e§l• Invisibilité").setLore("§aVous avez déjà acheté cette effect !","§eObtenez l''efffet §lInvisibilité","§7(L''effet se dissipe quand vous mourrez.)","","§7Prix: §a250,000⛂","§7Cliquez pour acheter.").toItemStack());
        if (player.getActivePotionEffects().stream().anyMatch(potionEffect -> potionEffect.getType().equals(PotionEffectType.DAMAGE_RESISTANCE) && potionEffect.getAmplifier() == 1)) inv.setItem(23, new ItemBuilder(HeadList.RESISTANCE.getItemStack()).setName("§e§l• Resistance II").setLore("§aVous avez déjà acheté cette effect !","§eObtenez l''efffet §lResistance II","§7Réduction de §e40% §7des dégâts","§7(L''effet se dissipe quand vous mourrez.)","","§7Prix: §a5,000,000⛂","§7Cliquez pour acheter.").toItemStack());
        if (player.getActivePotionEffects().stream().anyMatch(potionEffect -> potionEffect.getType().equals(PotionEffectType.FAST_DIGGING) && potionEffect.getAmplifier() == 2)) inv.setItem(24, new ItemBuilder(HeadList.HASTE.getItemStack()).setName("§e§l• Haste III").setLore("§aVous avez déjà acheté cette effect !","§eObtenez l''efffet §lHaste III","§7(L''effet se dissipe quand vous mourrez.)","","§7Prix: §a550,000⛂","§7Cliquez pour acheter.").toItemStack());
        return inv;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null || event.getCurrentItem().getItemMeta()== null) return;
        if (event.getInventory().getName().equals("» Atouts")) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getItemMeta().getDisplayName()){
                case "§e§l• 10 coeurs supplémentaires":
                    if (player.getActivePotionEffects().stream().anyMatch(potionEffect -> potionEffect.getType().equals(PotionEffectType.HEALTH_BOOST) && potionEffect.getAmplifier() == 4)){
                        player.closeInventory();
                        player.sendMessage("§cVous posséder déjà cette effect !");
                        return;
                    }
                    if (core.getEconomy().getBalance(player) < 750000) {
                        player.closeInventory();
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        return;
                    }
                    core.getEconomy().withdrawPlayer(player.getName(),750000);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,99999, 4));
                    player.closeInventory();
                    break;
                case "§e§l• Speed III":
                    if (player.getActivePotionEffects().stream().anyMatch(potionEffect -> potionEffect.getType().equals(PotionEffectType.SPEED) && potionEffect.getAmplifier() == 2)){
                        player.closeInventory();
                        player.sendMessage("§cVous posséder déjà cette effect !");
                        return;
                    }
                    if (core.getEconomy().getBalance(player) < 450000) {
                        player.closeInventory();
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        return;
                    }
                    core.getEconomy().withdrawPlayer(player.getName(),450000);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,99999, 2));
                    player.closeInventory();
                    break;
                case "§e§l• Invisibilité":
                    if (player.getActivePotionEffects().stream().anyMatch(potionEffect -> potionEffect.getType().equals(PotionEffectType.INVISIBILITY))){
                        player.closeInventory();
                        player.sendMessage("§cVous posséder déjà cette effect !");
                        return;
                    }
                    if (core.getEconomy().getBalance(player) < 25000) {
                        player.closeInventory();
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        return;
                    }
                    core.getEconomy().withdrawPlayer(player.getName(),25000);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,99999,1));
                    player.closeInventory();
                    break;
                case "§e§l• Resistance II":
                    if (player.getActivePotionEffects().stream().anyMatch(potionEffect -> potionEffect.getType().equals(PotionEffectType.DAMAGE_RESISTANCE) && potionEffect.getAmplifier() == 1)){
                        player.closeInventory();
                        player.sendMessage("§cVous posséder déjà cette effect !");
                        return;
                    }
                    if (core.getEconomy().getBalance(player) < 5000000) {
                        player.closeInventory();
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        return;
                    }
                    core.getEconomy().withdrawPlayer(player.getName(),5000000);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,99999, 1));
                    player.closeInventory();
                    break;
                case "§e§l• Haste III":
                    if (player.getActivePotionEffects().stream().anyMatch(potionEffect -> potionEffect.getType().equals(PotionEffectType.FAST_DIGGING) && potionEffect.getAmplifier() == 2)){
                        player.closeInventory();
                        player.sendMessage("§cVous posséder déjà cette effect !");
                        return;
                    }
                    if (core.getEconomy().getBalance(player) < 55000) {
                        player.closeInventory();
                        player.sendMessage("§cVous n'avez pas suffisamment d'argent");
                        return;
                    }
                    core.getEconomy().withdrawPlayer(player.getName(),550000);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,99999, 2));
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
