package org.dewOps.DesignVendingMechie.pojo;

public class ItemSelf {
    private Item item;
    private  int codeNumber;

    public ItemSelf(Item item, int codeNumber) {
        this.item = item;
        this.codeNumber = codeNumber;

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

}
