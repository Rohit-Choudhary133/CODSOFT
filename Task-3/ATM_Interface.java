/*1.Create a class to represent the ATM machine.
2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.
3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().
4. Create a class to represent the user's bank account, which stores the account balance.
5. Connect the ATM class with the user's bank account class to access and modify the account
balance.
6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.*/
import java.util.Scanner;

// Class representing a user's bank account
class BankAccount {
    private double balance; // This field is private and cannot be accessed directly from outside the class.

    // Constructor to initialize the account with a starting balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        if (amount > 0) { // Ensure the deposit amount is positive
            balance += amount; // Add the amount to the balance
            System.out.println(amount + "rs is deposited in your account.");
        } else {
            System.out.println("Invalid deposit amount."); // Handle invalid deposit
        }
    }

    // Method to withdraw an amount from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // Ensure the withdrawal amount is positive and does not exceed the balance
            balance -= amount; // Subtract the amount from the balance
            System.out.println(amount + "rs is withdrawn from your account.");
            return true; // Return true to indicate successful withdrawal
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal."); // Handle invalid or insufficient funds
            return false; // Return false to indicate unsuccessful withdrawal
        }
    }
}

// Class representing the ATM interface
public class ATM_Interface {
    private BankAccount account; // The user's bank account
    private Scanner scanner; // Scanner for user input

    // Constructor to initialize the ATM interface with a bank account and scanner
    public ATM_Interface(BankAccount account, Scanner scanner) {
        this.account = account; // Assign the provided bank account
        this.scanner = scanner; // Assign the provided scanner
    }

    // Method to display the ATM menu and handle user interactions
    public void showMenu() {
        int option = 0; // Variable to store the user's menu choice

        do {
            // Display the ATM menu
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            option = scanner.nextInt(); // Read the user's menu choice

            // Handle the user's menu choice
            switch (option) {
                case 1:
                    checkBalance(); // Check and display the account balance
                    break;
                case 2:
                    deposit(); // Deposit an amount into the account
                    break;
                case 3:
                    withdraw(); // Withdraw an amount from the account
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!"); // Exit the ATM
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // Handle invalid menu choice
            }
        } while (option != 4); // Repeat until the user chooses to exit
    }

    // Method to check and display the account balance
    private void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance()); // Print the current balance
    }

    // Method to deposit an amount into the account
    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble(); // Read the deposit amount
        account.deposit(amount); // Deposit the amount into the account
    }

    // Method to withdraw an amount from the account
    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble(); // Read the withdrawal amount
        account.withdraw(amount); // Withdraw the amount from the account
    }

    // Main method to run the ATM application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        BankAccount myAccount = new BankAccount(10000.00); // Create a bank account with an initial balance of 10000
        ATM_Interface atm = new ATM_Interface(myAccount, scanner); // Create an ATM interface with the bank account and scanner
        atm.showMenu(); // Show the ATM menu and handle user interactions
        scanner.close(); // Close the Scanner object to release resources
    }
}
