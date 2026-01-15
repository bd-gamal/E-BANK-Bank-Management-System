import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter client name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter client number: ");
                    String clientNumber = scanner.nextLine();
                    bank.addClient(new Client(name, clientNumber));
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double bal = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter account type (Standard/Business): ");
                    String type = scanner.nextLine();
                    bank.createAccount(new Account(accNum, bal, type));
                    break;

                case 3:
                    bank.displayAllAccounts();
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String searchNum = scanner.nextLine();
                    Account acc = bank.findAccount(searchNum);
                    if (acc != null) {
                        System.out.println("Balance: " + acc.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    String depNum = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depAmt = scanner.nextDouble();
                    Account depAcc = bank.findAccount(depNum);
                    if (depAcc != null) depAcc.deposit(depAmt);
                    break;

                case 6:
                    System.out.print("Enter account number: ");
                    String witNum = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double witAmt = scanner.nextDouble();
                    Account witAcc = bank.findAccount(witNum);
                    if (witAcc != null) witAcc.withdraw(witAmt);
                    break;

                case 7:
                    System.out.print("Enter account number to delete: ");
                    String delNum = scanner.nextLine();
                    bank.deleteAccount(delNum);
                    break;

                case 0:
                    System.out.println("GOODBYE!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 0);

        scanner.close();
    }
}