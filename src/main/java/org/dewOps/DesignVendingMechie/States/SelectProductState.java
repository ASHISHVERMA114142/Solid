package org.dewOps.DesignVendingMechie.States;

import org.dewOps.DesignVendingMechie.Enums.Coin;
import org.dewOps.DesignVendingMechie.pojo.Item;
import org.dewOps.DesignVendingMechie.pojo.VendingMechine;

import java.util.ArrayList;
import java.util.List;

public class SelectProductState extends State{

    public SelectProductState(){
        System.out.println("vending mechine is now on the selection state");
    }

    public void chooseProduct(VendingMechine vendingMechine , int code) throws Exception {
        Item item = vendingMechine.getInventory().getItem(code);
        int sum = 0;
        for(Coin coin : vendingMechine.getCoinList()){
            sum += coin.value;
        }
        if(sum < item.getPrice()) {
            System.out.println(" you have amount short for this produce = " + (sum - item.getPrice()));
            refundFullMoney(vendingMechine);
            throw  new Exception("amount is not enought");
        }
        getChange(sum - item.getPrice());
        vendingMechine.setVendingMechineState(new DispenseState(vendingMechine, code));
        State state = vendingMechine.getVendingMechineState();
        state.despenseProduct();
    }
    int getChange(int returnChangeMoney)throws  Exception{
        System.out.println("Returning the change money " + returnChangeMoney);
        return returnChangeMoney;
    }
    List<Coin> refundFullMoney(VendingMechine vendingMechine)throws  Exception{
        List<Coin> coinList = vendingMechine.getCoinList();
        vendingMechine.setCoinList(new ArrayList<>());
        vendingMechine.setVendingMechineState(new IdelState());
        return coinList;
    }

}
