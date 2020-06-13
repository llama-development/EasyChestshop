package net.lldv.easychestshop.components.manager;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemIds;
import cn.nukkit.player.Player;
import cn.nukkit.utils.Identifier;

public class Manager {

    public static void createChestShopItem(Player player, String itemString, int amount, double price, int type) {
        Item item = Item.get(Identifier.fromString("minecraft:wall_sign"), 0, 1);
        player.getInventory().addItem(item);
    }

}
