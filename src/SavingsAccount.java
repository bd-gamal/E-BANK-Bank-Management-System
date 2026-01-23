public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, String accountType, Client owner, double interestRate) {
        super(accountNumber, balance, accountType, owner);
        this.interestRate = interestRate;
    }

    public double calculateInterest(){
        return getBalance() * interestRate;
    }

    public void applyInterest(){
        double interest = calculateInterest();
        double newBalance = getBalance() + interest;
        setBalance(newBalance);

        System.out.println("Interest applied : " + interest + " . New balance : " + getBalance());
    }

    public void displayDetails(){
        System.out.println("Savings Account N° : " + getAccountNumber() + " | Balance : " + getBalance() + " | Rate : " + (interestRate * 100) + "%" + " | Properties : " + getOwner().getName());
    }
}
