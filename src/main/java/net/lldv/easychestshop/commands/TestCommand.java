package net.lldv.easychestshop.commands;

import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.item.Item;
import cn.nukkit.player.Player;
import cn.nukkit.utils.Identifier;
import net.lldv.easychestshop.EasyChestshop;
import net.lldv.easychestshop.components.tools.Command;

public class TestCommand extends PluginCommand<EasyChestshop> {

    public TestCommand(EasyChestshop owner) {
        super(owner, Command.create("test", "Test Command", ""));
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender.isPlayer()) {
            Player player = (Player) sender;
            Item item = Item.get(Identifier.fromString("minecraft:wall_sign"), 0, 1);
            player.getInventory().addItem(item);
        }
        return true;
    }
}
