public class Client extends Person{
    private String clientNumber;

    public Client(String name, String clientNumber) {
        super(name);
        this.clientNumber = clientNumber;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void displayDetails() {
        System.out.println("Name : "+ name +" | N° Client : "+ clientNumber);
    }
}