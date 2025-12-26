package org.dewOps.DesignVendingMechie.pojo;

import org.dewOps.DesignVendingMechie.Enums.ItemType;

;

public class Inventory {
    private ItemSelf itemSelves[] ;
    public Inventory(int capacity){
        itemSelves = new ItemSelf[capacity];
        initiateEmptyInventory();
    }

    public ItemSelf[] getItemSelfList() {
        return itemSelves;
    }
    public void setInventory(ItemSelf[] inventory) {
        this.itemSelves = inventory;
    }
    private void initiateEmptyInventory(){
        int code = 101;
        for(int i = 0; i < itemSelves.length; i++){
            Item item = new Item();
            ItemSelf space = new ItemSelf(item, code);
            itemSelves[i] = space;
            code ++;
        }
    }
    public void addItem(int code, Item item) throws  Exception{
        for(ItemSelf itemSelf: itemSelves){
            if(itemSelf.getCodeNumber() == code){
                itemSelf.setItem(item);
                itemSelf.getItem().setSoldOut(false);
            }else{
                throw new Exception("Please select the correct code number");
            }
        }
    }
    public Item getItem(int codeNumber) throws Exception {

        for (ItemSelf itemShelf : itemSelves) {
            if (itemShelf.getCodeNumber() == codeNumber) {
                if (itemShelf.getItem().isSoldOut()) {
                    throw new Exception("item already sold out");
                } else {
//                    updateItemStatus(itemShelf.getItem());
                    return itemShelf.getItem();
                }
            }
        }
        System.out.println("you don't have anything");
        return null;
    }

    public void updateItemStatus(Item item){
        item.decreaseItemCount();
        if(item.getItemCount() == 0) item.setSoldOut(true);
    }
}
