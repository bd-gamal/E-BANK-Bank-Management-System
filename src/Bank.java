import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> clients;
    private List<Account> accounts;

    public Bank() {
        this.clients = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
        System.out.println("Client added with success.");
    }

    public void createAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created with success.");
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (Account acc : accounts) {
                acc.displayDetails();
            }
        }
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void deleteAccount(String accountNumber) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            accounts.remove(acc);
            System.out.println("Account deleted!");
        } else {
            System.out.println("Account not found.");
        }
    }

}