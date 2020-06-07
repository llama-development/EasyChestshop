package net.lldv.easychestshop;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.registry.CommandRegistry;
import net.lldv.easychestshop.commands.ConverterCommand;

public class EasyChestshop extends PluginBase {

    @Override
    public void onLoad() {
        CommandRegistry cr = getServer().getCommandRegistry();
        cr.register(this, new ConverterCommand(this));
    }

    @Override
    public void onEnable() {

    }


}
