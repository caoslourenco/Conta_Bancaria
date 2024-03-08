package account.controller;

import java.util.ArrayList;

import account.model.Account;
import account.repository.AccountRepository;

public class AccountController implements AccountRepository {
    private ArrayList<Account> accountList = new ArrayList<Account>();
    int number = 0;

    @Override
    public void findByNumber(int number) {
        var account = findInCollection(number);

        if (account != null)
            account.print();
        else
            System.out.println("\nThe account number: " + number + " was not found!");
    }

    @Override
    public void listAll() {
        for (var account : accountList) {
            account.print();
        }
    }

    @Override
    public void create(Account account) {
        accountList.add(account);
        System.out.println("Account number: " + account.getNumber() + " was created successfully!");
    }

    @Override
    public void update(Account account) {
        var foundAccount = findInCollection(account.getNumber());

        if (foundAccount != null) {
            accountList.set(accountList.indexOf(foundAccount), account);
            System.out.println("\nAccount number: " + account.getNumber() + " was updated successfully!");
        } else
            System.out.println("\nAccount number: " + account.getNumber() + " was not found!");
    }

    @Override
    public void delete(int number) {
        var account = findInCollection(number);

        if (account != null) {
            if (accountList.remove(account)) {
                System.out.println("Your account has been successfully deleted!");
            } else {
                System.out.println("Your account was not found!");
            }
        }

    }

    @Override
    public void withdraw(int number, float value) {
        var account = findInCollection(number);

        if (account != null) {
            if (account.withdraw(value)) {
                System.out.println("\nWithdraw from account number: " + number + " was successful!");
            }
        } else {
            System.out.println("\nAccount number: " + number + " not found!");
        }
    }

    @Override
    public void deposit(int number, float value) {
        var account = findInCollection(number);

        if (account != null) {
            account.deposit(value);
            System.out.println("\nDeposit into account number " + number + " was successful!");
        } else {
            System.out.println("\nAccount number: " + number + " not found or"
                    + " the destination account is not a checking account!");
        }

    }

    @Override
    public void transfer(int originNumber, int destinationNumber, float value) {
        var originAccount = findInCollection(originNumber);
        var destinationAccount = findInCollection(destinationNumber);

        if (originAccount != null && destinationAccount != null) {
            if (originAccount.withdraw(value)) {
                destinationAccount.deposit(value);
                System.out.println("\nTransfer completed successfully!");
            }
        } else {
            System.out.println("\nThe origin account or the destination account were not found!");
        }

    }

    public int generateNumber() {
        return ++number;
    }

    public Account findInCollection(int number) {
        for (var account : accountList) {
            if (account.getNumber() == number) {
                return account;
            }
        }

        return null;

    }

    public int returnType(int number) {
        for (var account : accountList) {
            if (account.getNumber() == number) {
                return account.getType();
            }
        }
        return 0;
    }

}
