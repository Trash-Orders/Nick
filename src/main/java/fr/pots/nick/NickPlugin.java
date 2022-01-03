package fr.pots.nick;

import fr.mrcubee.langlib.Lang;
import org.bukkit.plugin.java.JavaPlugin;

public class NickPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        String defaultLang = null;

        saveDefaultConfig();
        if (getConfig().contains("default_lang"))
            defaultLang = getConfig().getString("default_lang");
        if(defaultLang != null)
            Lang.setDefaultLang(defaultLang);
        else
            Lang.setDefaultLang("FR_fr");
    }

    @Override
    public void onDisable() {

    }
}