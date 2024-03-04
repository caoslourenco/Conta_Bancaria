contabancaria/
│
└─── account/
    │
    └─── Menu.java
    │
    └─── utils/
        │
        └─── Colors.java




```classDiagram
    class BankAccount {
        - accountNumber: int
        - balance: double
        + BankAccount(accountNumber: int)
        + deposit(amount: double): void
        + withdraw(amount: double): boolean
        + getBalance(): double
    }
    class Menu
    class Colors```

***
