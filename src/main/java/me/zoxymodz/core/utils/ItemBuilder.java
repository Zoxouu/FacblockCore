package me.zoxymodz.core.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

public class ItemBuilder
{
    private ItemStack is;

    public ItemBuilder(final Material m) {
        this(m, 1);
    }

    public ItemBuilder(final ItemStack is) {
        this.is = is;
    }

    public ItemBuilder(final Material m, final int amount) {
        this.is = new ItemStack(m, amount);
    }

    public ItemBuilder(final Material m, final int amount, final short meta) {
        this.is = new ItemStack(m, amount, meta);
    }

    public ItemBuilder clone() {
        return new ItemBuilder(this.is);
    }


    public  ItemStack createSkull(String url){
        ItemStack head = is;
        if (url.isEmpty()) return head;

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));

        try
        {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);

        }
        catch (IllegalArgumentException|NoSuchFieldException|SecurityException | IllegalAccessException error)
        {
            error.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    public ItemBuilder setAmount(int amount) {
        this.is.setAmount(amount);
        return this;
    }

    public ItemBuilder setDurability(final short dur) {
        this.is.setDurability(dur);
        return this;
    }

    public ItemBuilder setName(final String name) {
        final ItemMeta im = this.is.getItemMeta();
        im.setDisplayName(name);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder addUnsafeEnchantment(final Enchantment ench, final int level) {
        this.is.addUnsafeEnchantment(ench, level);
        return this;
    }

    public ItemBuilder removeEnchantment(final Enchantment ench) {
        this.is.removeEnchantment(ench);
        return this;
    }

    public ItemBuilder setSkullOwner(final String p) {
        if (is instanceof SkullMeta) {
            ((SkullMeta) is).setOwner(p);
        }
        return this;
    }

    public ItemBuilder addEnchant(final Enchantment ench, final int level) {
        final ItemMeta im = this.is.getItemMeta();
        im.addEnchant(ench, level, true);
        this.is.setItemMeta(im);
        return this;
    }

   /* public ItemBuilder setInfinityDurability() {
        this.is.getItemMeta().set(true);
        return this;
    }*/

    public ItemBuilder setLore(final String... lore) {
        final ItemMeta im = this.is.getItemMeta();
        im.setLore(Arrays.asList(lore));
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setWoolColor(final DyeColor color) {
        if (!this.is.getType().equals((Object)Material.WOOL)) {
            return this;
        }
        this.is.setDurability((short)color.getWoolData());
        return this;
    }



    public ItemBuilder setLeatherArmorColor(final Color color) {
        try {
            final LeatherArmorMeta im = (LeatherArmorMeta)this.is.getItemMeta();
            im.setColor(color);
            this.is.setItemMeta((ItemMeta)im);
        }
        catch (ClassCastException ex) {}
        return this;
    }

    public ItemBuilder removeFlags(ItemFlag... flags){
        final ItemMeta im = is.getItemMeta();
        im.addItemFlags(flags);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder removeFlags(){
        return removeFlags(ItemFlag.values());
    }

    public ItemStack toItemStack() {
        return this.is;
    }
    public ItemBuilder setGlassPaneColor(DyeColor color)
    {
        if (!this.is.getType().equals(Material.STAINED_GLASS_PANE))
        {
            return this;
        }
        this.is.setDurability(color.getWoolData());
        return this;
    }

    public ItemBuilder setSkullOwner(Player p) {
        // TODO Auto-generated method stub
        return null;
    }
}
