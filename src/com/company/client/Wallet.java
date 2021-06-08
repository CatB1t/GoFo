package com.company.client;

public class Wallet {
    private long ewalletBalance;

    public long getEwalletBalance() {
        return ewalletBalance;
    }

    public void setEwalletBalance(long ewalletBalance) {
        this.ewalletBalance = ewalletBalance;
    }

    private int ewalletID;
    private long amount;


    public int getEwalletID() {
        return ewalletID;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setEwalletID(int ewalletID) {
        this.ewalletID = ewalletID;
    }
    public void transferMoney(int ID, long amt){

    }
    public long checkBalance(int ID){

        return 0;
    }

}
