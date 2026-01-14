import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=====!!! WELCOME TO BANK MANAGEMENT SYSTEM !!!=====");

        do  {
            System.out.println("\n---Main Menu---");
            System.out.println("1. Add a client");
            System.out.println("2. Create an account");
            System.out.println("3. Display accounts");
            System.out.println("4. Check balance");
            System.out.println("5. Deposit money");
            System.out.println("6. Withdraw money");
            System.out.println("7. Delete account");
            System.out.println("8. Calculate interest");
            System.out.println("0. Exit");
            System.out.println("Your choice: ");

            choice = scanner.nextInt();
            scanner.nextline();

            switch (choice) {
                case 1:
                    System.out.println("Enter Client ID : ");
                    int clientID = scanner.nextInt();
                    System.out.println("Enter Client Name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Client Number (ex C101) : ");
                    String clientNumber = scanner.nextLine();
                    myBank.addClient(new Client(clientID, name, clientNumber));
                    break;

                case 2:
                    System.out.println("Enter Account ID : ");
            }
        }

    }
}