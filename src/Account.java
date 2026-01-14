    public class Account {
        protected String accountNumber;
        protected double balance;
        protected Client owner;

        public Account(String accountNumber, double initialBalance, Client owner) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
            this.owner = owner;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit success. New balance : " + balance);
            } else {
                System.out.println("Invalid amount.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdraw success. New balance : " + balance);
                return true;
            }
            System.out.println("insufficient balance or invalid amount.");
            return false;
        }

        public void displayInfo() {
            System.out.println("Account number: " + accountNumber + " | Balance: " + balance + " | Properties: " + owner.getName());
        }

        public String getAccountNumber() { return accountNumber; }
        public double getBalance() { return balance; }
    }

