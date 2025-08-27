// Instance vs Static (Class) Members
// Task: Create a program that clearly demonstrates the difference between instance and static
// members.
// public class BankAccount {
// // TODO: Create static variables:
// // - bankName (String) - same for all accounts
// // - totalAccounts (int) - count of all accounts created
// // - interestRate (double) - same rate for all accounts
// // TODO: Create instance variables:
// // - accountNumber (String) - unique for each account
// // - accountHolder (String) - unique for each account
// // - balance (double) - unique for each account
// // TODO: Create constructor that:
// // - Initializes instance variables
// // - Increments totalAccounts counter
// // TODO: Create static methods:
// // - setBankName(String name)
// // - setInterestRate(double rate)
// // - getTotalAccounts() - returns count
// // - displayBankInfo() - shows bank name and total accounts
// // TODO: Create instance methods:
// // - deposit(double amount)
// // - withdraw(double amount)
// // - calculateInterest() - uses static interestRate
// // - displayAccountInfo()
// public static void main(String[] args) {
// // TODO: Set bank name and interest rate using static methods
// // TODO: Create multiple BankAccount objects
// // TODO: Show that static members are shared across all objects
// // TODO: Show that instance members are unique to each object

// // TODO: Demonstrate calling static methods with and without
// objects
// }
// }
import java.util.Scanner;

public class InsVsStatic {
    static private String bankName;
    static private int totalAccounts = 0;
    static private double interestRate;
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public static String getBankName() {
        return bankName;
    }

    public static void setBankName(String bankName) {
        InsVsStatic.bankName = bankName;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void setTotalAccounts(int totalAccounts) {
        InsVsStatic.totalAccounts = totalAccounts;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        InsVsStatic.interestRate = interestRate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public InsVsStatic(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        InsVsStatic.totalAccounts = InsVsStatic.totalAccounts + 1;
    }

    public void DepositAmount(double amount) {
        balance = balance + amount;

    }

    public void WithdrawAmount(double amount) {
        if (balance >= amount) {
            System.out.println("balance withdrawn");
            balance = balance - amount;
        } else {
            System.out.println("insufficent balance ");
        }
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public void displayAccountInfo() {
        System.out.println("bankName : " + bankName + "account number :" +
                accountNumber + "account holder :" + accountHolder + "account balance " + balance);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InsVsStatic acc1 = new InsVsStatic("12345", "samir", 56789);
        setBankName("chitwan development bank");
        System.out.println(getBankName());

        input.close();
    }
}