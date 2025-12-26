package org.dewOps.DesignVendingMechie;

import org.dewOps.DesignVendingMechie.Enums.Coin;
import org.dewOps.DesignVendingMechie.Enums.ItemType;
import org.dewOps.DesignVendingMechie.States.State;
import org.dewOps.DesignVendingMechie.pojo.Inventory;
import org.dewOps.DesignVendingMechie.pojo.Item;
import org.dewOps.DesignVendingMechie.pojo.ItemSelf;
import org.dewOps.DesignVendingMechie.pojo.VendingMechine;

public class Main {
    public static void main(String[] args) {
        System.out.println("DesignVendingMechine");
        VendingMechine vendingMachine = new VendingMechine(10);
        try {

            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMechineState();
            vendingState.clickOnCoinInsertButton(vendingMachine);

            vendingState = vendingMachine.getVendingMechineState();
            vendingState.insertCoinVendingMechine(vendingMachine, Coin.NICKEL);
            vendingState.insertCoinVendingMechine(vendingMachine, Coin.QUARTER);
            // vendingState.insertCoin(vendingMachine, Coin.NICKEL);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getVendingMechineState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        }
        catch (Exception e){
            System.out.println("something went wrong");
            displayInventory(vendingMachine);
        }

    }
    private static void fillUpInventory(VendingMechine vendingMachine){
        ItemSelf[] slots = vendingMachine.getInventory().getItemSelfList();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i >=0 && i<3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i >=3 && i<5){
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i >=5 && i<7){
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i >=7 && i<10){
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].getItem().setSoldOut(false);
        }
    }
    private static void displayInventory(VendingMechine vendingMachine){

        ItemSelf[] slots = vendingMachine.getInventory().getItemSelfList();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getCodeNumber() +
                    " Item: " + slots[i].getItem().getItemType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].getItem().isSoldOut());
        }
    }
}
