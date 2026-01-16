public class Account {
    protected String accountNumber;
    protected double balance;
    protected String accountType;
    protected Client owner;

    public Account(String accountNumber, double balance, String accountType, Client owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.owner = owner;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public Client getOwner() { return owner; }

    public void displayDetails() {
        System.out.println("Account number: " + accountNumber + " | Balance: " + balance + " | Type: " + accountType + " | Owner: " + owner.getName());
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit success. New balance: " + balance);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal success. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}