![LinkedIn banner game designer neon roxo e azul (1)](https://github.com/caoslourenco/contabancaria/assets/18141491/37aeb8b8-e26c-4859-b14b-d83f4f9536e3)


***
This project was developed during the first block of the Generation bootcamp. In this phase, I was introduced to the Object-Oriented Paradigm, and for the first time, I was able to put CRUD (Create, Read, Update, and Delete) into practice

```
contabancaria/
│
└─── account/
    │
    └─── Menu.java
    │
    └─── utils/
        │
        └─── Colors.java




classDiagram
    class BankAccount {
        - accountNumber: int
        - balance: double
        + BankAccount(accountNumber: int)
        + deposit(amount: double): void
        + withdraw(amount: double): boolean
        + getBalance(): double
    }
    class Menu
    class Colors

***
