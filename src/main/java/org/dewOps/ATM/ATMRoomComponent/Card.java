package org.dewOps.ATM.ATMRoomComponent;

import java.time.LocalDate;
import java.util.Date;

public class Card {

    private Integer cardNumber;
    private Integer carCvv;
    public LocalDate expiryDate;
    private int pin ;
    private String holderName;
    private UserBankAccount bankAccount;

    public Card(Integer cardNumber, Integer carCvv, LocalDate expiryDate, int pin, String holderName, UserBankAccount bankAccount) {
        this.cardNumber = cardNumber;
        this.carCvv = carCvv;
        this.expiryDate = expiryDate;
        this.pin = pin;
        this.holderName = holderName;
        this.bankAccount = bankAccount;
    }

    public boolean checkPinValidation(int pin){
        return this.pin == pin;
    }
    public int getBankBalance() {
        return bankAccount.getBalanceAmount();
    }

    public int deductBankBalance(int amount){
        return bankAccount.withdrawAmount(amount);
    }
    public void setBankAccount(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
