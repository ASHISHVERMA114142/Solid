package org.dewOps.ATM.ATMRoomComponent;

import org.dewOps.ATM.ATMStates.ATMStates;
import org.dewOps.ATM.ATMStates.IdelState;

public class ATM {
    private static ATM atmObject = new ATM();
    ATMStates atmStates = new IdelState();


    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;
    private int atmBalance;
    public ATM(){
        System.out.println("creating the atm ");
    }
    public void setAtmObject(int atmBalance, int noOfFiveHundredNotes, int noOfOneHundredNotes, int noOfTwoThousandNotes){
        this.atmBalance = atmBalance;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public int getAtmBalance() {
        return atmBalance;
    }
    public void deductAtmBalance(int amout){
        this.atmBalance -= amout;
    }
    public void deductNoOfFiveHundredNotes(int count){
        this.noOfFiveHundredNotes -= count;
    }
    public void deductNoOfOneHundredNotes(int count){
        this.noOfOneHundredNotes -= count;
    }
    public void deductNoOfTwoThousandNotes(int count){
        this.noOfTwoThousandNotes -= count;
    }
    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public void setNoOfOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }
    public ATMStates getAtmStates() {
        return atmStates;
    }

    public void setAtmStates(ATMStates atmStates) {
        this.atmStates = atmStates;
    }
    @Override
    public String toString() {
        return "ATM{" +
                "atmStates=" + atmStates +
                ", noOfTwoThousandNotes=" + noOfTwoThousandNotes +
                ", noOfFiveHundredNotes=" + noOfFiveHundredNotes +
                ", noOfOneHundredNotes=" + noOfOneHundredNotes +
                ", atmBalance=" + atmBalance +
                '}';
    }
}
