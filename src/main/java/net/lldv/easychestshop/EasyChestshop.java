package net.lldv.easychestshop;

import cn.nukkit.level.Sound;
import cn.nukkit.player.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.registry.CommandRegistry;
import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.packet.PlaySoundPacket;
import net.lldv.easychestshop.commands.ChestShopCommand;
import net.lldv.easychestshop.commands.TestCommand;
import net.lldv.easychestshop.components.language.Language;

public class EasyChestshop extends PluginBase {

    private static EasyChestshop instance;

    @Override
    public void onLoad() {
        instance = this;
        Language.init();
        CommandRegistry cr = getServer().getCommandRegistry();
        cr.register(this, new TestCommand(this));
        cr.register(this, new ChestShopCommand(this));
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
    }

    public static EasyChestshop getInstance() {
        return instance;
    }

    public void playSound(Player player, Sound sound) {
        PlaySoundPacket packet = new PlaySoundPacket();
        packet.setSound(sound.getSound());
        packet.setPosition(Vector3f.from(player.getX(), player.getY(), player.getZ()));
        packet.setVolume(1.0F);
        packet.setPitch(1.0F);
        player.sendPacket(packet);
    }
}
