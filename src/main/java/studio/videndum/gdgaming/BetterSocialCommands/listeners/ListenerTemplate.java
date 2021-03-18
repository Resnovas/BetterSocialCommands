package studio.videndum.gdgaming.BetterSocialCommands.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

public interface ListenerTemplate extends Listener {
    void init(FileConfiguration config);
}
