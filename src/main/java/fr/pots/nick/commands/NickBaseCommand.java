package fr.pots.nick.commands;

import fr.mrcubee.langlib.Lang;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author MrCubee
 * @since 1.0
 * @version 1.0
 */
public abstract class NickBaseCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final Player targetPlayer;

        if (args.length < 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(Lang.getMessage("command.must.player",
                "&cERROR LANG: command.must.player", true));
                return true;
            }
            targetPlayer = (Player) sender;
        } else {
            targetPlayer = Bukkit.getPlayerExact(args[0]);
            if (targetPlayer == null) {
                sender.sendMessage(Lang.getMessage(sender,
                "command.target.not_found",
                "&cERROR LANG: command.target.not_found", true));
                return true;
            }
        }
        return onCommand(sender, targetPlayer);
    }

    /**
     * @author MrCubee
     * @since 1.0
     * @param sender Whoever sent the command.
     * @param targetPlayer The player to disguise.
     * @return Returns true if the command syntax has been respected, otherwise returns false.
     */
    public abstract boolean onCommand(CommandSender sender, Player targetPlayer);

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
