package org.dewOps.ATM.ATMStates;

import org.dewOps.ATM.ATMRoomComponent.ATM;
import org.dewOps.ATM.ATMRoomComponent.Card;

public class CheckBalanceState extends ATMStates {

    public CheckBalanceState() {
    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your Balance is: " + card.getBankBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setAtmStates(new IdelState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
