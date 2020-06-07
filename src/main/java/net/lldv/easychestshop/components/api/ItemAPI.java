package net.lldv.easychestshop.components.api;

import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.utils.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ItemAPI {

    // itemInfo,Lore,Enchantments
    // name#slot#id#damage#count,lore1#lore2#lore2,id:level#id:level
    // [?1] = #
    // [?2] = /
    // [?3] = ,

    public static String toString(Item item, int slot) {
        StringBuilder sb = new StringBuilder();
        String customName = "none";
        if (item.getCustomName() != null) customName = encodeString(item.getCustomName());
        sb.append(customName).append("#");
        sb.append(slot).append("#");
        sb.append(item.getId().toString()).append("#");
        sb.append(item.getMeta()).append("#");
        sb.append(item.getCount()).append(",");

        // #,/

        for (String lore : item.getLore()) {
            String replacedLore = encodeString(lore);
            sb.append(replacedLore).append("#");
        }
        sb.append(",");

        for (Enchantment enchantment : item.getEnchantments()) {
            sb.append(enchantment.getId())
                    .append(":")
                    .append(enchantment.getLevel())
                    .append("#");
        }
        return sb.toString();
    }

    // itemInfo,Lore,Enchantments
    // name#slot#id#damage#count,lore1#lore2#lore2,id:level#id:level

    public static ItemWithSlot fromString(String itemString) throws NumberFormatException {
        String[] info = itemString.split(",");
        String[] general = info[0].split("#");
        String name = decodeString(general[0]);
        int slot = Integer.parseInt(general[1]);
        Identifier itemid = Identifier.fromString(general[2]);
        int meta = Integer.parseInt(general[3]);
        int count = Integer.parseInt(general[4]);
        Item item = Item.get(itemid, meta, count);
        if (!name.equals("none")) item.setCustomName(name);
        try {
            String[] lores = info[1].split("#");
            if (lores.length != 0) {
                List<String> list = new ArrayList<>();
                for (String lore : lores) {
                    list.add(decodeString(lore));
                }
                item.setLore(list);
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        try {
            String[] enStrings = info[2].split("#");
            for (String encString : enStrings) {
                String[] eInfo = encString.split(":");
                Enchantment enchantment = Enchantment.get(Integer.parseInt(eInfo[0])).setLevel(Integer.parseInt(eInfo[1]));
                item.addEnchantment(enchantment);
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        return new ItemWithSlot(item, slot);
    }

    private static String decodeString(String str) {
        return str.replace("[?1]", "#")
                .replace("[?2]", "/")
                .replace("[?3]", ",");
    }

    private static String encodeString(String str) {
        return str.replace("#", "[?1]")
                .replace("/", "[?2]")
                .replace(",", "[?3]");
    }

    public static class ItemWithSlot {

        private final Item item;
        private final int slot;


        public ItemWithSlot(Item item, int slot) {
            this.item = item;
            this.slot = slot;
        }

        public Item getItem() {
            return item;
        }

        public int getSlot() {
            return slot;
        }
    }

}
