package net.lldv.easychestshop.commands;

import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.item.Item;
import cn.nukkit.player.Player;
import net.lldv.easychestshop.EasyChestshop;
import net.lldv.easychestshop.components.api.ItemAPI;
import net.lldv.easychestshop.components.tools.Command;

public class ConverterCommand extends PluginCommand<EasyChestshop> {

    private String converted = "";

    public ConverterCommand(EasyChestshop owner) {
        super(owner, Command.create("converter", "Converter Command", "/converter <set/get>"));
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender.isPlayer()) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("set")) {
                    converted = ItemAPI.toString(player.getInventory().getItemInHand(), 7);
                    player.sendMessage(converted);
                } else if (args[0].equalsIgnoreCase("get")) {
                    ItemAPI.ItemWithSlot item = ItemAPI.fromString(converted);
                    player.sendMessage("Check 7. slot");
                    player.getInventory().setItem(item.getSlot(), item.getItem());
                } else if (args[0].equalsIgnoreCase("shuffle")) {
                    player.sendMessage("Shuffled your item");
                    Item item = player.getInventory().getItemInHand();
                    item.setCustomName("#Kacken");
                    item.setLore("#Kacken!", "/kacken");
                    player.getInventory().setItemInHand(item);
                }
            }
        }
        return true;
    }
}
