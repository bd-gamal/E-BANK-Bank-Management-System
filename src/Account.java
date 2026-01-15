public class Account {
    protected String accountNumber;
    protected double balance;
    protected String accountType;

    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void displayDetails() {
        System.out.println("Account number : "+ accountNumber +" | Balance : "+ balance +" | Account type : "+ accountType);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit succes. New balance : "+ balance);
        } else {
            System.out.println("Invalid amount !");
        }
    }

    public void withdraw(double amount) {

    }
}