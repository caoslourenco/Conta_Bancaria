package account.model;

public class Menu {
    public static void main(String[] args) {
        Account account1 = new Account("João", 123456, 789, 1000.0f);
        Account account2 = new Account("Maria", 654321, 987, 500.0f);

        // Testing the methods of the Account class
        System.out.println("Account information for " + account1.getHolder() + ":");
        System.out.println("Account number: " + account1.getNumber());
        System.out.println("Agency: " + account1.getAgency());
        System.out.println("Balance: " + account1.getBalance());

        System.out.println("\nAccount information for " + account2.getHolder() + ":");
        System.out.println("Account number: " + account2.getNumber());
        System.out.println("Agency: " + account2.getAgency());
        System.out.println("Balance: " + account2.getBalance());
    }
}


// MENU TEST