package org.dewOps.DesignVendingMechie.States;

import org.dewOps.DesignVendingMechie.pojo.Item;
import org.dewOps.DesignVendingMechie.pojo.VendingMechine;

public class DispenseState extends State{
    VendingMechine vendingMechine;
    int code;
    public DispenseState(VendingMechine vendingMechine, int code){
        this.vendingMechine = vendingMechine;
        this.code = code;
    }
   public Item despenseProduct()throws  Exception{
        System.out.println("despensing the item");
        Item item = vendingMechine.getInventory().getItem(code);
        System.out.println("despensing the item " + item.toString());
        vendingMechine.getInventory().updateItemStatus(item);
        vendingMechine.setVendingMechineState(new IdelState());
        return item;
    }
}
