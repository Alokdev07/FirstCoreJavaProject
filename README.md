# Banking System - Core Java

This is a simple banking system project developed using Core Java. It allows users to create accounts, deposit and withdraw money, check balance, and transfer funds between accounts.

## Features

- **Account Creation:** Users can create a new account with basic details like name and initial deposit.
- **Deposit:** Users can deposit money into their account.
- **Withdraw:** Users can withdraw money from their account (provided they have sufficient balance).
- **Balance Check:** Users can view the current balance of their account.
- **Fund Transfer:** Users can transfer money from one account to another.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) version 8 or higher.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans) or a simple text editor.
- Command-line tools (if you prefer to run the project without an IDE).

## Setup

1. Clone this repository to your local machine:
    ```bash
    git clone https://github.com/your-username/java-banking-system.git
    ```

2. Navigate to the project directory:
    ```bash
    cd java-banking-system
    ```

3. Compile the Java files:
    ```bash
    javac *.java
    ```

4. Run the application:
    ```bash
    java BankingSystem
    ```

## How It Works

### Account Creation
To create a new account, the user is prompted to enter:
- Name of the account holder
- Initial deposit amount

Once created, the system will assign an account number to the new account.

### Deposits
Users can deposit money into their account. The deposit will increase the account balance.

### Withdrawals
Users can withdraw money from their account. The system will check if there are sufficient funds to perform the withdrawal.

### Balance Check
The user can check their current account balance by selecting the option to view the balance.

### Fund Transfer
Users can transfer funds between accounts. The system will check both the sender's balance and the recipient's account details to ensure the transaction is successful.

## Classes and Functions

### `BankingSystem.java`
- Main class that starts the banking system and drives user interactions.
  
### `Account.java`
- Class that represents an individual bank account, storing account holder information and balance.

### `AccountManager.java`
- Class responsible for managing all the accounts, including adding, removing, and searching for accounts.

## Example Usage

### 1. Creating an Account
```java
Enter name: John Doe
Enter initial deposit: 1000
Account created successfully! Account Number: 123456

