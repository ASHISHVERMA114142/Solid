package org.dewOps.ATM.ATMRoomComponent;

public class UserBankAccount {

    private String accountHolderName;
    private String address;
    private int balanceAmount;

    public UserBankAccount(String accountHolderName, String address, int balanceAmount) {
        this.accountHolderName = accountHolderName;
        this.address = address;
        this.balanceAmount = balanceAmount;
    }

    public int withdrawAmount(int amount){
        if(amount <= balanceAmount) {
            balanceAmount = balanceAmount - amount;
            return amount;
        }else{
            System.out.println(" not sufficient amount is on your account ");
        }
        return 0;
    }
    public int getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
