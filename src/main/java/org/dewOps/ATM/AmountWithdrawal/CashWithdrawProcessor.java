package org.dewOps.ATM.AmountWithdrawal;

import org.dewOps.ATM.ATMRoomComponent.ATM;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextCashWithdrawProcessor;
    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor){
        this.nextCashWithdrawProcessor = cashWithdrawProcessor;
    }
    public void withdraw(ATM atm, int amount){
        if(nextCashWithdrawProcessor != null){
            nextCashWithdrawProcessor.withdraw(atm, amount);
        }
    }
}
