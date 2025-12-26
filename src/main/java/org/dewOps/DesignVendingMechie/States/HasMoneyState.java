package org.dewOps.DesignVendingMechie.States;

import org.dewOps.DesignVendingMechie.Enums.Coin;
import org.dewOps.DesignVendingMechie.pojo.Item;
import org.dewOps.DesignVendingMechie.pojo.VendingMechine;

import java.util.ArrayList;
import java.util.List;

public class HasMoneyState extends State{
    public void clickOnStartProductSelectionButton(VendingMechine vendingMechine)throws  Exception{
        vendingMechine.setVendingMechineState(new SelectProductState());
    }
    public void insertCoinVendingMechine(VendingMechine vendingMechine, Coin coin)throws  Exception{
        System.out.println("Inserted coin into the vending mechine ");
        List<Coin> coinList = vendingMechine.getCoinList();
        coinList.add(coin);
        int sum = 0;
        for(Coin c : coinList){
            sum += c.value;
        }
        System.out.println("you have entered total coin amount = " + sum);

    }
    List<Coin> refundFullMoney(VendingMechine vendingMechine)throws  Exception{
        List<Coin> coinList = vendingMechine.getCoinList();
        vendingMechine.setCoinList(new ArrayList<>());
        vendingMechine.setVendingMechineState(new IdelState());
        return coinList;
    }
}
