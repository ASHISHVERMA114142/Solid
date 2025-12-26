package org.dewOps.DesignVendingMechie.States;

import org.dewOps.DesignVendingMechie.Enums.Coin;
import org.dewOps.DesignVendingMechie.pojo.Item;
import org.dewOps.DesignVendingMechie.pojo.VendingMechine;
import java.util.List;

public abstract class State {

    public void clickOnCoinInsertButton(VendingMechine vendingMechine) throws  Exception{
        // default behaviour ...
    }
    public void clickOnStartProductSelectionButton(VendingMechine vendingMechine)throws  Exception{
        // default behaviour
    }
    public void insertCoinVendingMechine(VendingMechine vendingMechine, Coin coin)throws  Exception{
        // default behaviour
    }
    int getChange(int returnChangeMoney)throws  Exception{
        return 0;
    }
    Item despenseProduct()throws  Exception{
        return null;
    }
    List<Coin> refundFullMoney(VendingMechine vendingMechine)throws  Exception{
        return null;
    }
    void updateInventory(VendingMechine vendingMechine, Item item, int codeNumber)throws  Exception{
        // nothing to return here ...
    }

    public void chooseProduct(VendingMechine vendingMachine, int i) throws Exception {
    }
}
