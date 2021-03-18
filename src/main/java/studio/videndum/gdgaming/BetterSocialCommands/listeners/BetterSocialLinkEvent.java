package studio.videndum.gdgaming.BetterSocialCommands.listeners;

import com.alonsoaliaga.bettersocial.api.events.SocialLinkEvent;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

import java.util.List;

import static org.bukkit.Bukkit.*;

public class BetterSocialLinkEvent implements ListenerTemplate {
    private ConfigurationSection config;

    public void init(FileConfiguration config) {
        this.config = config.getConfigurationSection("identifiers");
        assert this.config != null : "No config provided - 'identifiers'";
    }

    @EventHandler (priority = EventPriority.HIGH)
    public void onSocialLink (SocialLinkEvent event) {
        String Identifier = event.getSocialIdentifier();
        ConfigurationSection IdentifierConfig = config.getConfigurationSection(Identifier);
        assert IdentifierConfig != null : "No config provided - " + Identifier;
        if (IdentifierConfig.getBoolean("enabled", false)) {
            getLogger().info("BetterSocialLinkEvent hooked Identifier: " + Identifier);
            List<String> Commands = IdentifierConfig.getStringList("linkedCommands");
            for (String Command : Commands) {
                if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) return;
                Command = PlaceholderAPI.setPlaceholders(event.getPlayer(), Command);
                if (Command.startsWith("console: ")) {
                    getLogger().info("Console running command: " + Command.substring("console: ".length()));
                    dispatchCommand(getConsoleSender(), Command.substring("console: ".length()));
                } else {
                    getLogger().info("Player running command: " + Command);
                    dispatchCommand(event.getPlayer(), Command);
                }
            }
        }
    }
}
