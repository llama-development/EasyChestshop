package net.lldv.easychestshop.commands;

import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.player.Player;
import net.lldv.easychestshop.EasyChestshop;
import net.lldv.easychestshop.components.manager.FormManager;
import net.lldv.easychestshop.components.tools.Command;

public class ChestShopCommand extends PluginCommand<EasyChestshop> {

    public ChestShopCommand(EasyChestshop owner) {
        super(owner, Command.create("chestshop", "Create a Chestshop", ""));
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender.isPlayer()) {
            Player player = (Player) sender;
            FormManager.sendCreateForm(player);
        }
        return true;
    }
}
