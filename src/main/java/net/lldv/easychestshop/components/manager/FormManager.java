package net.lldv.easychestshop.components.manager;

import cn.nukkit.form.CustomForm;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.player.Player;
import net.lldv.easychestshop.components.language.Language;

public class FormManager {

    public static void sendCreateForm(Player player) {

        Item item = player.getInventory().getItemInHand();

        String enchantments = "", lores = "";

        if (item.getLore().length <= 0) lores = Language.getNP("c-no-lores");
        else {
            for (String lore : item.getLore()) {
                lores += Language.getAndReplaceNP("c-lore", lore) + ", ";
            }
            lores = lores.substring(0, lores.length() - 2);
        }
        if (item.getEnchantments().length <= 0) enchantments = Language.getNP("c-no-enchantments");
        else {
            for (Enchantment e : item.getEnchantments()) {
                enchantments += Language.getAndReplaceNP("c-enchantment", e.getName(), formatLevel(e.getLevel())) + ", ";
            }
            enchantments = enchantments.substring(0, enchantments.length() - 2);
        }


        CustomForm customForm = new CustomForm.CustomFormBuilder()
                .title(Language.getNP("c-title"))
                .label(Language.getAndReplaceNP("c-content", item.getName(), enchantments, lores))
                .dropdown(Language.getNP("c-type"), 0, Language.getNP("c-sell"), Language.getNP("c-buy"))
                .input(Language.getNP("c-price"), Language.getNP("c-price-p"))
                .input(Language.getNP("c-amount"), Language.getNP("c-amount-p"))
                .onSubmit((p, r) -> {
                    p.sendMessage(":o");
                })
                .build();
        player.showFormWindow(customForm);
    }

    private static String formatLevel(final int level) {
        switch (level) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            default:
                return "" + level;
        }
    }

}
