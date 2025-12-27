package org.dewOps.ATM.ATMStates;

import org.dewOps.ATM.ATMRoomComponent.ATM;
import org.dewOps.ATM.ATMRoomComponent.Card;

public class IdelState extends ATMStates{

    public IdelState(){
        System.out.println("Atm is on the idel state");
    }
    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("card has been inserted into the atm mechine");
        atm.setAtmStates(new HasCardState());
    }
}
