package org.dewOps.ATM.ATMStates;

import org.dewOps.ATM.ATMRoomComponent.ATM;
import org.dewOps.ATM.ATMRoomComponent.Card;

import javax.persistence.Id;

public class HasCardState extends ATMStates {

    public HasCardState() {
        System.out.println("enter your card pin number");
    }
    @Override
    public void authenticatePin(ATM atm, Card card, int pin){
        System.out.println("please wait we are authenticating your pinc");
        if(card.checkPinValidation(pin)){
            System.out.println("pin validation is sucessful");
            atm.setAtmStates(new SelectOperationState());
        }else{
            returnCard();
            exit(atm);
        }
    }
    @Override
    public void returnCard(){
        System.out.println("sucessfully returnCard");
    }
    @Override
    public void exit(ATM atm) {
        System.out.println("cancelling the txn , returning to homepage");
        atm.setAtmStates(new IdelState());
    }
}
