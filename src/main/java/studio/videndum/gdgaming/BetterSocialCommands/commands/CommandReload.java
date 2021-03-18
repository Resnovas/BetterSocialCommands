package studio.videndum.gdgaming.BetterSocialCommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import studio.videndum.gdgaming.BetterSocialCommands.BetterSocialCommands;

public class CommandReload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && "reload".equalsIgnoreCase(args[0]) && sender.hasPermission("bettersocial.admin")) {
            BetterSocialCommands.get().reload();
            sender.sendMessage("[BetterSocialCommands] Reloaded");
        } else {
            sender.sendMessage("[BetterSocialCommands] Running version " + BetterSocialCommands.get().getDescription().getVersion());
        }
        return true;
    }
}
