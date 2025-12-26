package org.dewOps.DesignVendingMechie.pojo;

import org.dewOps.DesignVendingMechie.Enums.ItemType;

public class Item {
    private int price;
    private ItemType itemType;
    private int itemCount;
    private boolean isSoldOut;

    public Item() {
        this.itemCount = 1;
    }
    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }
    public int getItemCount() {
        return itemCount;
    }

    public void addItemCount(int itemCount) {
        this.itemCount += itemCount;
    }
    public void decreaseItemCount(){
        this.itemCount -= 1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", itemType=" + itemType +
                ", itemCount=" + itemCount +
                ", isSoldOut=" + isSoldOut +
                '}';
    }
}
