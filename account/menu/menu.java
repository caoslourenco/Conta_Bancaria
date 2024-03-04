// Menu.java
package account;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private AccountManager accountManager;
    private Colors colors;

    public Menu() {
        scanner = new Scanner(System.in);
        accountManager = new AccountManager();
        colors = new Colors();
    }

    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the Bank Account System");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit into an existing account");
            System.out.println("3. Withdraw from an existing account");
            System.out.println("4. Check balance of an existing account");
            System.out.println("5. Display all accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAllAccounts();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.next();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        accountManager.createAccount(name, balance);
        System.out.println("Account created successfully.");
    }

    private void deposit() {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        boolean success = accountManager.deposit(accNumber, amount);
        if (success) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit failed. Invalid account number.");
        }
    }

    private void withdraw() {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        boolean success = accountManager.withdraw(accNumber, amount);
        if (success) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed. Invalid account number or insufficient balance.");
        }
    }

    private void checkBalance() {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        double balance = accountManager.checkBalance(accNumber);
        if (balance != -1) {
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Invalid account number.");
        }
    }

    private void displayAllAccounts() {
        accountManager.displayAllAccounts();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
