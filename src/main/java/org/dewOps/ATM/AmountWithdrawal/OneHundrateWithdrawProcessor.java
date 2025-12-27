package org.dewOps.ATM.AmountWithdrawal;

import org.dewOps.ATM.ATMRoomComponent.ATM;

public class OneHundrateWithdrawProcessor extends CashWithdrawProcessor{
    public OneHundrateWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }
    @Override
    public void withdraw(ATM atm, int remainingAmount){
        if(remainingAmount == 0) return ;
        int balanceRequired = remainingAmount % 100;
        int numberOfOnwHundrateNotes = remainingAmount / 100;
        int onwHundrateNotes = atm.getNoOfOneHundredNotes();
        if(onwHundrateNotes == 0){
            System.out.println("no 100 notes on mechine ....");
            super.withdraw(atm, remainingAmount);
        }else if(onwHundrateNotes >= numberOfOnwHundrateNotes){
            for(int i = 0; i < numberOfOnwHundrateNotes ; i++){
                System.out.println("here is your cash : " + " 100 ");
            }
            atm.setNoOfOneHundredNotes(onwHundrateNotes - numberOfOnwHundrateNotes);
            super.withdraw(atm, balanceRequired);
        }else{
            for(int i = 0; i < onwHundrateNotes ; i++){
                System.out.println("here is your cash : " + " 100 ");
            }
            atm.setNoOfOneHundredNotes(0);
            super.withdraw(atm, remainingAmount - onwHundrateNotes * 100);
        }

    }
}
