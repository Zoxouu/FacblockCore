package me.zoxymodz.core;

import me.zoxymodz.core.cmd.*;
import me.zoxymodz.core.gui.*;
import me.zoxymodz.core.gui.f2w.*;
import me.zoxymodz.core.listeners.PlayerListener;
import me.zoxymodz.core.manager.TeamsTagsManager;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class Core extends JavaPlugin {

    public LuckPerms api;
    private static final Logger log = Logger.getLogger("Minecraft");
    public Economy econ = null;


    @Override
    public void onEnable() {
        Core Core = this;
        registerListeners();
        registerCMD();
        sendTabList();
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            api = provider.getProvider();
        }
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    @Override
    public void onDisable() {}

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    private void sendTabList() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Group group = (Group) getApi().getGroupManager().getGroup(getApi().getUserManager().getUser(player.getName()).getPrimaryGroup());
                    TeamsTagsManager.setNameTag(player, String.valueOf(9999-group.getWeight().getAsInt()), group.getCachedData().getMetaData().getSuffix(),"");
                }
            }
        }, 0, 50);
    }
    private void registerCMD(){
        Bukkit.getPluginCommand("spawn").setExecutor(new SpawnCmd());
        Bukkit.getPluginCommand("grade").setExecutor(new GradeCmd(this));
        Bukkit.getPluginCommand("menu").setExecutor(new MenuCmd(this));
        Bukkit.getPluginCommand("f2w").setExecutor(new F2wCmd(this));
        Bukkit.getPluginCommand("atouts").setExecutor(new AtoutsCmd(this));
        Bukkit.getPluginCommand("annonce").setExecutor(new AnnonceCMD());
        Bukkit.getPluginCommand("test").setExecutor(new TestCMD(this));
    }
    private void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListener(this),this);
        pm.registerEvents(new GradeF2wGUI(this),this);
        pm.registerEvents(new F2wGUI(this),this);
        pm.registerEvents(new AtoutsF2wGUI(this),this);
        pm.registerEvents(new KitF2wGUI(this),this);
        pm.registerEvents(new ObjectF2wGUI(this),this);
        pm.registerEvents(new PointsFactionF2wGUI(this),this);
        pm.registerEvents(new MenuGUI(this),this);
    }

    public LuckPerms getApi() {
        return api;
    }
    public Economy getEconomy() {
        return econ;
    }
}
