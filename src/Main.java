import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("==== WELCOME TO BANK MANAGEMENT SYSTEM ====");

        do {
            System.out.println("\n---- Main Menu ----");
            System.out.println("1. Add a client");
            System.out.println("2. Create a bank account");
            System.out.println("3. Display Accounts");
            System.out.println("4. Check balance");
            System.out.println("5. Deposit money");
            System.out.println("6. Withdraw money");
            System.out.println("7. Delete account");
            System.out.println("8. Calculate interest");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter client name :");
                    String name = scanner.nextLine();
                    System.out.println("Enter client number :");
                    String clientNumber = scanner.nextLine();
                    myBank.addClient(new Client(name, clientNumber));
                    break;

                case 2:
                    System.out.println("Enter account ID :");
                    String accountNumber = scanner.nextLine();
                    System.out.println("Enter a balance :");
                    double balance = scanner.nextInt();
                    System.out.println("Enter an account type :");
                    String accountType = scanner.nextLine();
                    myAccount.addAccount(new Account(accountNumber, balance, accountType));
                    break;

                case 3:
                    System.out.println("All accounts : ");

            }
        }
    }
}