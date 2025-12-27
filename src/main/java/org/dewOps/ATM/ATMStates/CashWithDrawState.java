package org.dewOps.ATM.ATMStates;

import org.dewOps.ATM.ATMRoomComponent.ATM;
import org.dewOps.ATM.ATMRoomComponent.Card;
import org.dewOps.ATM.AmountWithdrawal.CashWithdrawProcessor;
import org.dewOps.ATM.AmountWithdrawal.FiveHundredWithdrawProcessor;
import org.dewOps.ATM.AmountWithdrawal.OneHundrateWithdrawProcessor;
import org.dewOps.ATM.AmountWithdrawal.TwoThousandWithdrawProcessor;
import org.dewOps.ATM.enums.TransactionType;

public class CashWithDrawState extends ATMStates {

    // cash-withdrawal-state,
    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount){

//      1st check your account and the atm machine has sufficent amount or not
        if(atm.getAtmBalance() < withdrawAmount){
            System.out.println("atm does not have the sufficent amout ");
        }else if(card.getBankBalance() < withdrawAmount){
            System.out.println("your account does not have the sufficent amount");
        }else{
            card.deductBankBalance(withdrawAmount);
            atm.deductAtmBalance(withdrawAmount);
            // chain of responsibility....
            CashWithdrawProcessor cashWithdrawProcessor = new TwoThousandWithdrawProcessor(
                    new FiveHundredWithdrawProcessor(
                            new OneHundrateWithdrawProcessor(null)
                    )
            );
            cashWithdrawProcessor.withdraw(atm,withdrawAmount);
            returnCard();
            exit(atm);
        }

    }
    // cash-withdrawal-state,
    @Override
    public void returnCard(){
        System.out.println("sucessfully returnCard");
    }
    @Override
    public void exit(ATM atm) {
        System.out.println("txn is complete now  , returning to homepage");
        atm.setAtmStates(new IdelState());
    }
}
