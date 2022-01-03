package fr.pots.nick;

import fr.mrcubee.langlib.Lang;
import fr.pots.nick.commands.NickCommand;
import fr.pots.nick.commands.UnNickCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author MrCubee
 * @since 1.0
 * @version 1.0
 */
public class NickPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        String defaultLang = null;
        final NickCommand nickCommandExecutor = new NickCommand();
        final UnNickCommand unNickCommandExecutor = new UnNickCommand();
        final PluginCommand nickCommand;
        final PluginCommand unNickCommand;

        saveDefaultConfig();
        if (getConfig().contains("default_lang"))
            defaultLang = getConfig().getString("default_lang");
        if(defaultLang != null)
            Lang.setDefaultLang(defaultLang);
        else
            Lang.setDefaultLang("FR_fr");
        nickCommand = getCommand("nick");
        if (nickCommand != null) {
            nickCommand.setExecutor(nickCommandExecutor);
            nickCommand.setTabCompleter(nickCommandExecutor);
        }
        unNickCommand = getCommand("unnick");
        if (unNickCommand != null) {
            unNickCommand.setExecutor(unNickCommandExecutor);
            unNickCommand.setTabCompleter(unNickCommandExecutor);
        }
    }
}