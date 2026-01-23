import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("==== WELCOME TO BANK MANAGEMENT SYSTEM ====");

        do {
           try {
            System.out.println("\n---- Main Menu ----");
            System.out.println("1. Add a client");
            System.out.println("2. Create a new bank account");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Check balance of an account");
            System.out.println("5. Deposit money");
            System.out.println("6. Withdraw money");
            System.out.println("7. Delete account");
            System.out.println("8. Calculate interest (Savings)");
            System.out.println("9. Export data to Excel");
            System.out.println("10. Transfer money");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Client name : ");
                    String name = scanner.nextLine();
                    System.out.print("Client number : ");
                    String clientNum = scanner.nextLine();
                    bank.addClient(new Client(name, clientNum));
                    break;

                case 2:
                    System.out.print("Client number for the owner : ");
                    String ownNum = scanner.nextLine();
                    Client owner = bank.findClient(ownNum);

                    if (owner != null) {
                        System.out.print("Account number : ");
                        String accNumber = scanner.nextLine();
                        System.out.print("Initial balance : ");
                        double balance = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Account type : 1. Standard | 2. Savings");
                        System.out.print("Choice : ");
                        int typeChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (typeChoice == 2) {
                            System.out.print("Interest rate (e.g., 0.02 for 2%) : ");
                            double rate = scanner.nextDouble();
                            scanner.nextLine();

                            SavingsAccount sa = new SavingsAccount(accNumber, balance, "Savings", owner, rate);
                            bank.createAccount(sa);
                            System.out.println("Savings account created successfully !");
                        } else {
                            Account sdAccount = new Account(accNumber, balance, "Standard", owner);
                            bank.createAccount(sdAccount);
                            System.out.println("Standard account created successfully !");
                        }
                    } else {
                        System.out.println("No client found. Please enter a new client first");
                    }
                    break;

                case 3:
                    bank.displayAllAccounts();
                    break;

                case 4:
                    System.out.print("Account number : ");
                    String searchAcc = scanner.nextLine();
                    Account acc = bank.findAccount(searchAcc);
                    if (acc != null) {
                        System.out.println("Balance: " + acc.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Account number : ");
                    String depNum = scanner.nextLine();
                    System.out.print("Amount to deposit : ");
                    double depAmt = scanner.nextDouble();
                    Account depAcc = bank.findAccount(depNum);
                    if (depAcc != null) {
                        depAcc.deposit(depAmt);
                    } else {
                        System.out.println("Account number " + depNum + " does not exist !");
                    }
                    break;

                case 6:
                    System.out.print("Account number : ");
                    String witNum = scanner.nextLine();
                    System.out.print("Amount to withdraw : ");
                    double witAmt = scanner.nextDouble();
                    Account witAcc = bank.findAccount(witNum);
                    if (witAcc != null) {
                        witAcc.withdraw(witAmt);
                    } else {
                        System.out.println("Account number " + witNum + " does not exist !");
                    }
                    break;

                case 7:
                    System.out.print("Account number to delete : ");
                    String delNum = scanner.nextLine();
                    bank.deleteAccount(delNum);
                    break;

                case 8:
                    System.out.print("Savings account N° :");
                    String savNumber = scanner.nextLine();
                    Account savAccount = bank.findAccount(savNumber);
                    if (savAccount instanceof SavingsAccount) {
                        ((SavingsAccount) savAccount).applyInterest();
                    } else {
                        System.out.println("This is not a savings account !");
                    }
                    break;

                case 9:
                    System.out.println("Exporting data to Excel...");
                    ExcelExport.exportAccountsToExcel(bank.getAccounts(), "Bank_accounts.xlsx");
                    break;

                case 10:
                    System.out.println("---> Money Transfer <---");

                    System.out.print("Source account number : ");
                    String srcNum = scanner.nextLine();
                    Account srcAcc = bank.findAccount(srcNum);

                    System.out.print("Destination account number : ");
                    String desNum = scanner.nextLine();
                    Account desAcc = bank.findAccount(desNum);

                    if (srcAcc != null && desAcc != null) {
                        System.out.print("Amount to transfer : ");
                        double transAmnt = scanner.nextDouble();
                        scanner.nextLine();

                        srcAcc.moneyTransfer(desAcc, transAmnt);
                    } else {
                        if (srcAcc == null) {
                            System.out.println("Source account not found !");
                        }
                        if (desAcc == null) {
                            System.out.println("Destination account not found !");
                        }
                    }
                    break;

                case 0:
                    System.out.println("GOODBYE!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
           } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a number.");
            scanner.nextLine();
            choice = -1;
           }
        } while (choice != 0);

        scanner.close();
   }
}