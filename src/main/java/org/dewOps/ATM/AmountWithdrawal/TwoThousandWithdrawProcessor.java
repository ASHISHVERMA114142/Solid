package org.dewOps.ATM.AmountWithdrawal;

import org.dewOps.ATM.ATMRoomComponent.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor{

    public TwoThousandWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }
    @Override
    public void withdraw(ATM atm, int remainingAmount){
        if(remainingAmount == 0) return ;
        int balanceRequired = remainingAmount % 2000;
        int numberOfTwoThousantNotes = remainingAmount / 2000;
        int towThousandNotesOnATM = atm.getNoOfTwoThousandNotes();
        if(towThousandNotesOnATM == 0){
            System.out.println("no 2000 notes on mechine ....");
            super.withdraw(atm, remainingAmount);
        }else if(towThousandNotesOnATM >= numberOfTwoThousantNotes){
            for(int i = 0; i < numberOfTwoThousantNotes ; i++){
                System.out.println("here is your cash : " + " 2000 ");
            }
            atm.setNoOfTwoThousandNotes(towThousandNotesOnATM - numberOfTwoThousantNotes);
            super.withdraw(atm, balanceRequired);
        }else{
            for(int i = 0; i < towThousandNotesOnATM ; i++){
                System.out.println("here is your cash : " + " 2000 ");
            }
            atm.setNoOfTwoThousandNotes(0);
            super.withdraw(atm, remainingAmount - towThousandNotesOnATM * 2000);
        }

    }
}
