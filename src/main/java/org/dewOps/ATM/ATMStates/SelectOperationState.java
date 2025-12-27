package org.dewOps.ATM.ATMStates;

import org.dewOps.ATM.ATMRoomComponent.ATM;
import org.dewOps.ATM.ATMRoomComponent.Card;
import org.dewOps.ATM.enums.TransactionType;

public class SelectOperationState extends ATMStates {

    public SelectOperationState() {
        showOperations();
    }

    @Override
    public void selectOperation(ATM atmObject, Card card, TransactionType txnType) {
        switch (txnType) {
            case CASH_WITHDRAWAL:
                atmObject.setAtmStates(new CashWithDrawState());
                break;
            case CHECK_BALANCE:
                atmObject.setAtmStates(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Option");
                exit(atmObject);
            }
        }
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

    private void showOperations() {
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionType();
    }
}
