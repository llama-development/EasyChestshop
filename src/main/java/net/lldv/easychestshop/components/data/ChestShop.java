package net.lldv.easychestshop.components.data;

import cn.nukkit.item.Item;
import com.nukkitx.math.vector.Vector3i;

public class ChestShop {

    private String id, owner, world;
    private Item item;
    private double price;
    private int amount, type;
    private Vector3i chestPosition;
    private Vector3i position;

    public ChestShop(String id, String owner, Item item, int amount, double price, int type, Vector3i position, Vector3i chestPosition, String world) {
        this.id = id;
        this.owner = owner;
        this.item = item;
        this.amount = amount;
        this.price = price;
        this.type = type;
        this.position = position;
        this.chestPosition = chestPosition;
        this.world = world;
    }

    public Item getItem() {
        return item;
    }

    public Vector3i getPosition() {
        return position;
    }

    public Vector3i getChestPosition() {
        return chestPosition;
    }

    public String getWorld() {
        return world;
    }

    public int getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public String getOwner() {
        return owner;
    }

    public class Type {
        public static final int SELL = 0, BUY = 1;
    }

}
