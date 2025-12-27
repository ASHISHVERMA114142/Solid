package org.dewOps.ATM.AmountWithdrawal;

import org.dewOps.ATM.ATMRoomComponent.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }
    @Override
    public void withdraw(ATM atm, int remainingAmount){
        if(remainingAmount == 0) return ;
        int balanceRequired = remainingAmount % 500;
        int numberOfFiveHundrateNotes = remainingAmount / 500;
        int fiveHundrateNotes = atm.getNoOfOneHundredNotes();
        if(fiveHundrateNotes == 0){
            System.out.println("no 100 notes on mechine ....");
            super.withdraw(atm, remainingAmount);
        }else if(fiveHundrateNotes >= numberOfFiveHundrateNotes){
            for(int i = 0; i < numberOfFiveHundrateNotes ; i++){
                System.out.println("here is your cash : " + " 500 ");
            }
            atm.setNoOfFiveHundredNotes(fiveHundrateNotes - numberOfFiveHundrateNotes);
            super.withdraw(atm, balanceRequired);
        }else{
            for(int i = 0; i < fiveHundrateNotes ; i++){
                System.out.println("here is your cash : " + " 500 ");
            }
            atm.setNoOfFiveHundredNotes(0);
            super.withdraw(atm, remainingAmount - fiveHundrateNotes * 500);
        }

    }
}
