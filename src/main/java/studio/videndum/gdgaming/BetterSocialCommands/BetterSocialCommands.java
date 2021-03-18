package studio.videndum.gdgaming.BetterSocialCommands;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import studio.videndum.gdgaming.BetterSocialCommands.commands.CommandReload;
import studio.videndum.gdgaming.BetterSocialCommands.listeners.*;
import studio.videndum.gdgaming.BetterSocialCommands.listeners.ListenerTemplate;

public class BetterSocialCommands extends JavaPlugin {
    private static BetterSocialCommands plugin;
    public static BetterSocialCommands get() {return plugin;}

    BetterSocialLinkEvent betterSocialLink = new BetterSocialLinkEvent();
    betterSocialUnlinkEvent betterSocialUnlink = new betterSocialUnlinkEvent();

    @Override
    public void onEnable () {
        plugin = this;
        getLogger().info("Better Social Commands Enabled");
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        this.listeners(config);
        this.getCommand("bettersocialcommands").setExecutor(new CommandReload());
    }

    private void listeners (FileConfiguration config){
        this.initListener(betterSocialLink, config);
        this.initListener(betterSocialUnlink, config);
    }

    private void initListener(ListenerTemplate listener, FileConfiguration config) {
        try {
            listener.init(config);
            getServer().getPluginManager().registerEvents(listener, this);
        } catch (Error error) {
            this.showError(error.getMessage());
        }
    }

    public void reload() {
        reloadConfig();
        HandlerList.unregisterAll(this);
        this.listeners(getConfig());
    }

    public void showError(String errorMessage) {
        getLogger().severe("=============================================================================================");
        getLogger().severe("!!!  " + errorMessage);
        getLogger().severe("=============================================================================================");
    }

    @Override
    public void onDisable () {
        getLogger().info("Better Social Commands Disabled");
    }
}
