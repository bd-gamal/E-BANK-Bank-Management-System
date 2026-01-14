public class Client extends Person {
    private String clientNumber;

    public Client(int id, String name, String clientNumber) {
        super(id, name);
        this.clientNumber = clientNumber;
    }

    @Override
    public void displayDetails() {
        System.out.println("Client ID: " + id + " | Name: " + name + " | Client Number: " + clientNumber);
    }

    public String getClientNumber() { return clientNumber; }
}