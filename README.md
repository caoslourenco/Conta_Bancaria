![LinkedIn banner game designer neon roxo e azul (3)](https://github.com/caoslourenco/contabancaria/assets/18141491/ca6502dc-b021-459e-8536-db2c18d130ca)

<!--

![LinkedIn banner game designer neon roxo e azul (1)](https://github.com/caoslourenco/contabancaria/assets/18141491/37aeb8b8-e26c-4859-b14b-d83f4f9536e3)

 ?
 
![LinkedIn banner game designer neon roxo e azul (2)](https://github.com/caoslourenco/contabancaria/assets/18141491/169ee795-f0d8-4bc5-b94f-7c33d32c2e30) -->

***
This project was developed during the first block of the Generation bootcamp. In this phase, I was introduced to the Object-Oriented Paradigm, and for the first time, I was able to put CRUD (Create, Read, Update, and Delete) into practice

```
contabancaria/
│
└─── account/
    │
    └─── Menu.java
    │
    └─── Model/
        │
        └─── Account.java
        │
    │   └─── menutest.java
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

```

### 🏦 The Project consists of the following Classes and Interfaces:

| Class/Interface    | Description                                                |
| ------------------- | --------------------------------------------------------- |
| **Menu**            | Main class, containing the `main` method, responsible for creating the initial application menu with all system functionalities. |
| **Colors**          | Utility class, responsible for applying colors to the menu. |
| **Account**         | Class responsible for defining the generic Account object. |
| **CheckingAccount** | Class responsible for defining the Checking Account object. |
| **SavingsAccount**  | Class responsible for defining the Savings Account object. |
| **AccountRepository** | Interface responsible for encapsulating the methods to be used in the application menu. |
| **AccountController** | Class responsible for implementing the AccountRepository interface. |

***
###  📍Features and Functionalities:

- [x] Utility class for color customization.
- [x] Abstract class implementation for extensibility.
- [x] Exception handling for error management.
- [x] CRUD (Create, Read, Update, Delete) operations for data manipulation.
- [x] Banking methods for financial transactions and operations.

***
 
&nbsp;
<p align="right" style="color: #FFD700;">
      <img src="https://komarev.com/ghpvc/?username=cloruenc&label=Money+deposit++💵+&color=800080" alt="Money deposit 💵"/>
  </a>
</p>
