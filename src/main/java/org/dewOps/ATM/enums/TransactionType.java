package org.dewOps.ATM.enums;

public enum TransactionType {
    CASH_WITHDRAWAL,
    CHECK_BALANCE;

    public static void showAllTransactionType(){
        System.out.println("*** ALL THE TRANSACTION TYPE ARE HERE ***");
        for(TransactionType type : TransactionType.values()){
            System.out.println(type);
        }
    }
}
