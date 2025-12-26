package org.dewOps.DesignVendingMechie.pojo;

import org.dewOps.DesignVendingMechie.Enums.Coin;
import org.dewOps.DesignVendingMechie.States.State;
import org.dewOps.DesignVendingMechie.States.IdelState;

import java.util.ArrayList;
import java.util.List;

public class VendingMechine {
    private State state ;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMechine(int inventoryCapacity){
        state = new IdelState(this);
        inventory = new Inventory(10);
        coinList = new ArrayList<>();
    }

    public State getVendingMechineState() {
        return state;
    }

    public void setVendingMechineState(State state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
