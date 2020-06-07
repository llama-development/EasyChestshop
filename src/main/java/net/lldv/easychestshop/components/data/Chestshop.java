package net.lldv.easychestshop.components.data;

import cn.nukkit.item.Item;
import com.nukkitx.math.vector.Vector3i;

public class Chestshop {

    private final String UUID;
    private final String owner;
    private final String ownerUUID;
    private final Vector3i position;
    private final String world;
    private final Item item;
    private final int type;
    private final double price;
    private final Vector3i chestPosition;

    public Chestshop(String chestUUID, String owner, String ownerUUID, Vector3i position, String world, Item item, int type, double price, Vector3i chestPosition) {
        this.UUID = chestUUID;
        this.owner = owner;
        this.ownerUUID = ownerUUID;
        this.position = position;
        this.world = world;
        this.item = item;
        this.type = type;
        this.price = price;
        this.chestPosition = chestPosition;
    }

    public String getOwner() {
        return owner;
    }

    public double getPrice() {
        return price;
    }

    public int getType() {
        return type;
    }

    public Item getItem() {
        return item;
    }

    public String getOwnerUUID() {
        return ownerUUID;
    }

    public String getUUID() {
        return UUID;
    }

    public String getWorld() {
        return world;
    }

    public Vector3i getChestPosition() {
        return chestPosition;
    }

    public Vector3i getPosition() {
        return position;
    }
}
