package org.dewOps.DesignVendingMechie.States;

import org.dewOps.DesignVendingMechie.pojo.Item;
import org.dewOps.DesignVendingMechie.pojo.ItemSelf;
import org.dewOps.DesignVendingMechie.pojo.VendingMechine;

import java.util.ArrayList;

public class IdelState extends State {
    public IdelState(){
        System.out.println("machine is on the idel state");
    }
    public IdelState(VendingMechine vendingMechine){
        System.out.println("machine is on the idel state");
        vendingMechine.setCoinList(new ArrayList<>());
    }
    public void clickOnCoinInsertButton(VendingMechine vendingMechine)throws  Exception{
        System.out.println("changing state of vendig mechine to hasMoneyState");
        vendingMechine.setVendingMechineState(new HasMoneyState());
    }
    void updateInventory(VendingMechine vendingMechine, Item item, int codeNumber)throws  Exception{
        vendingMechine.getInventory().addItem(codeNumber, item);
    }
}