package org.example;

public class Main {
    public static void main(String[] args) {
        BankAcct paulAccount = new BankAcct();
        paulAccount.depositAmount(120.0);

        paulAccount.depositAmount(250);
        paulAccount.withdraw(100);

        paulAccount.depositAmount(500);
        paulAccount.withdraw(500.30);
    }

}