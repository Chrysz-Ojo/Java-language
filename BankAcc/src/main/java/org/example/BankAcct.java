package org.example;

public class BankAcct {
    private String Name;
    private String AccountNumber;
    private double AccountBalance;
    private String Email;
    private String PhoneNumber;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        AccountBalance = accountBalance;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public double Withdraw(double withdraw) {
        System.out.println();
        AccountBalance -= withdraw;
        return AccountBalance;
    }

    public void depositAmount(double depositAmount) {
        AccountBalance += depositAmount;
        System.out.println("deposit of $" + depositAmount + "made.New Balance is $" +
                AccountBalance);

    }
    public void withdraw (double withdrawAmount){
          if (AccountBalance - withdrawAmount < 0) {
                  System.out.println("Your balance is 0.00$" + "balance + in your account.");
            } else {
              AccountBalance -= withdrawAmount;
              System.out.println("withdraw of $" + withdrawAmount + "processed, Remaining balance = $" + AccountBalance);
           }
        }
    }





