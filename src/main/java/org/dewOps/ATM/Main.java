package org.dewOps.ATM;

import org.dewOps.ATM.ATMRoomComponent.ATM;
import org.dewOps.ATM.ATMRoomComponent.Card;
import org.dewOps.ATM.ATMRoomComponent.User;
import org.dewOps.ATM.ATMRoomComponent.UserBankAccount;
import org.dewOps.ATM.enums.TransactionType;

import java.time.LocalDate;
import java.util.Date;

public class Main {


    public static void main(String[] args) {
        ATM atm = new ATM();
        User user = createUser();
        initialize(atm,user);
        System.out.println(atm.toString());
        atm.getAtmStates().insertCard(atm, user.getCard());
        atm.getAtmStates().authenticatePin(atm, user.getCard(),1234);
        atm.getAtmStates().selectOperation(atm, user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atm.getAtmStates().cashWithdrawal(atm, user.getCard(),2300);
        System.out.println(atm.toString());
    }
    public static void initialize(ATM atm,User user){
        atm.setAtmObject(3500, 1, 5, 5);
    }

    private static User createUser() {

        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private static Card createCard() {

        UserBankAccount userBankAccount = createBankAccount();
        Card card = new Card(12,2323, LocalDate.of(2323,12,12),1234,"dewashiv",userBankAccount);
        return card;
    }

    private static UserBankAccount createBankAccount() {
        UserBankAccount bankAccount = new UserBankAccount("dewashiv","raipur", 3200);
        return bankAccount;
    }
}



