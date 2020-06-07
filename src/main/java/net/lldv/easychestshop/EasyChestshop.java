package net.lldv.easychestshop;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.registry.CommandRegistry;
import net.lldv.easychestshop.commands.ConverterCommand;
import net.lldv.easychestshop.components.language.Language;

public class EasyChestshop extends PluginBase {

    private static EasyChestshop instance;

    @Override
    public void onLoad() {
        CommandRegistry cr = getServer().getCommandRegistry();
        cr.register(this, new ConverterCommand(this));
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Language.init();
    }

    public static EasyChestshop getInstance() {
        return instance;
    }
}
