package account;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import account.controller.AccountController;
import account.model.CheckingAccount;
import account.model.SavingsAccount;
import account.util.Colors;

public class Menu {
    
    public static void main(String[] args) {
        String holder;
        float balance, limit, value; 
        int option, number, agency, type, anniversary, destinationNumber;
        AccountController accounts = new AccountController();
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            // User Information
            System.out.println(Colors.WHITE_BOLD_INTENSE);
            System.out.println("________________________________________\n");
            System.out.println("               BRAZIL BANK WITH Z");
            System.out.println("________________________________________\n");
            System.out.println("     1 - Create Account");
            System.out.println("     2 - List All Accounts");
            System.out.println("     3 - Search Account by Number");
            System.out.println("     4 - Update Account Data");
            System.out.println("     5 - Delete Account");
            System.out.println("     6 - Withdraw");
            System.out.println("     7 - Deposit");
            System.out.println("     8 - Transfer Funds between Accounts");
            System.out.println("     9 - Exit");
            System.out.println("________________________________________\n" + Colors.RESET);
            
            System.out.print(Colors.WHITE_BOLD_INTENSE + "Enter the desired option: ");
            try {
                option = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter integer values!");
                scan.nextLine();
                option = 0;
            }

            switch (option) {
                case 1:
                    System.out.println(Colors.WHITE_BOLD_INTENSE + "________________________________________\n");
                    System.out.println("             Create Account");
                    System.out.println("________________________________________\n");
                    
                    System.out.print("Enter the Agency number: ");
                    agency = scan.nextInt();
                    System.out.print("Enter the holder's name: ");
                    scan.skip("\\R?");
                    holder = scan.nextLine();
                    
                    do {
                        System.out.print("Enter the account type (1 - Checking Account or 2 - Savings Account): ");
                        type = scan.nextInt();
                    } while (type < 1 || type > 2);
                    
                    System.out.print("Enter the account balance (R$): ");
                    balance = scan.nextFloat();
                    
                    switch (type) {
                        case 1:
                            System.out.print("Enter the credit limit (R$): ");
                            limit = scan.nextFloat();
                            accounts.register(new CheckingAccount(holder, accounts.generateNumber(), agency, type, balance, limit));
                            break;
                        case 2:
                            System.out.print("Enter the account anniversary day: ");
                            anniversary = scan.nextInt();
                            accounts.register(new SavingsAccount(holder, accounts.generateNumber(), agency, type, balance, anniversary));
                            break;
                    }
                    
                    keyPress();
                    break;
                case 2:
                    System.out.println(Colors.WHITE_BOLD_INTENSE + "________________________________________\n");
                    System.out.println("         List All Accounts");
                    System.out.println("________________________________________\n");
                    accounts.listAll();
                    keyPress();
                    break;
                case 3:
                    System.out.println(Colors.WHITE_BOLD_INTENSE + "________________________________________\n");
                    System.out.println("        Consult Account Data");
                    System.out.println("________________________________________\n");
                    
                    System.out.print("Enter the account number: ");
                    number = scan.nextInt();
                    accounts.searchByNumber(number);
                    
                    keyPress();
                    break;
                case 4:
                    System.out.println(Colors.WHITE_BOLD_INTENSE + "________________________________________\n");
                    System.out.println("         Update Account Data");
                    System.out.println("________________________________________\n");
                    
                    System.out.print("Enter the account number: ");
                    number = scan.nextInt();
                    
                    if (accounts.searchInCollection(number) != null) {
                        
                        System.out.print("Enter the Agency number: ");
                        agency = scan.nextInt();
                        System.out.print("Enter the holder's name: ");
                        scan.skip("\\R?");
                        holder = scan.nextLine();
                        System.out.print("Enter the account balance (R$): ");
                        balance = scan.nextFloat();
                        
                        type = accounts.returnType(number);
                        
                        switch (type) {
                            case 1:
                                System.out.print("Enter the credit limit (R$): ");
                                limit = scan.nextFloat();
                                accounts.update(new CheckingAccount(holder, number, agency, type, balance, limit));
                                break;
                            case 2:
                                System.out.print("Enter the account anniversary day: ");
                                anniversary = scan.nextInt();
                                accounts.update(new SavingsAccount(holder, number, agency, type, balance, anniversary));
                                break;
                            default:
                                System.out.println("Invalid account type!");
                                break;
                        }
                    } else {
                        System.out.println("Account Not Found");
                    }
                    keyPress();
                    break;
                case 5:
                    System.out.println(Colors.WHITE_BOLD_INTENSE + "________________________________________\n");
                    System.out.println("             Delete Account");
                    System.out.println("________________________________________\n");
                    
                    System.out.print("Enter the account number: ");
                    number = scan.nextInt();    
                    accounts.delete(number);
                    
                    keyPress();
                    break;
                case 6:
                    System.out.println(Colors.WHITE_BOLD_INTENSE + "________________________________________\n");
                    System.out.println("                Withdraw");
                    System.out.println("________________________________________\n");
                    
                    System.out.print("Enter the account number: ");
                    number = scan.nextInt();
                    
                    do {
                        System.out.print("Enter the withdrawal amount (R$): ");
                        value = scan.nextFloat();
                    } while (value <= 0);
                    
                    accounts.withdraw(number, value);
                    keyPress();
                    break;
                case 7:
                    System.out.println(Colors.WHITE_BOLD_INTENSE + "________________________________________\n");
                    System.out.println("               Deposit");
                    System.out.println("________________________________________\n");

                    System.out.print("Enter the account number: ");
                    number = scan.nextInt();
                    
                    do {
                        System.out.print("Enter the deposit amount (R$): ");
                        value = scan.nextFloat();
                    } while (value <= 0);
                    
                    accounts.deposit(number, value);
                    
                    keyPress();
                    break;
                case 8:
                    System.out.println(Colors.WHITE_BOLD_INTENSE + "________________________________________\n");
                    System.out.println("     Transfer between Accounts");
                    System.out.println("________________________________________\n");
                    
                    System.out.print("Enter the origin account number: ");
                    number = scan.nextInt();
                    System.out.print("Enter the destination account number: ");
                    destinationNumber = scan.nextInt();    
                    
                    do {
                        System.out.print("Enter the transfer amount (R$): ");
                        value = scan.nextFloat();
                    } while (value <= 0);
                    
                    accounts.transfer(number, destinationNumber, value);

                    keyPress();
                    break;
                default:
                    System.out.println(Colors.WHITE_BOLD_INTENSE + "________________________________________\n" + Colors.RESET);
                    System.out.println(Colors.RED_BOLD_INTENSE + "            Invalid Option" + Colors.RESET);
                    System.out.println(Colors.WHITE_BOLD_INTENSE + "________________________________________\n");
                    
                    keyPress();
                    break;
            }
            
            if (option == 9) {
                System.out.println(Colors.WHITE_BOLD_INTENSE + "Brazil Bank with Z - Your Future Starts Here!");
                scan.close();
                System.exit(0);
            }
            
        }
    }
    
    public static void keyPress() {
        try {
            System.out.println(Colors.RESET + "Press enter to continue...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("You pressed a key other than enter!");
        }
    }
}

