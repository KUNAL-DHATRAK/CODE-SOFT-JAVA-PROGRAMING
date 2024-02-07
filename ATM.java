
//TASK 3
//
//        1.Create a class to represent the ATM machine.
//
//        2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
//        checking the balance.
//
//        3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
//        checkBalance().
//
//        4. Create a class to represent the user's bank account, which stores the account balance.
//
//        5. Connect the ATM class with the user's bank account class to access and modify the account
//        balance.
//
//        6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
//
//        7. Display appropriate messages to the user based on their chosen options and the success or failure
//        of their transactions.
//
//        ATM INTERFACE
import java.util.Scanner;

class BankAccount {

    private double balance;
    public double acc;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            System.out.println("Invalid deposit amount.");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
            return false;
        }
    }

    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {

        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: " + account.checkBalance());
                    } else {
                        System.out.println("Withdrawal failed.");
                    }
                    break;

                case "2":
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit successful. Current balance: " + account.checkBalance());
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    break;

                case "3":
                    System.out.println("Current Balance: " + account.checkBalance());
                    break;

                case "4":
                    System.out.println("Exiting ATM. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Account Number: ");
        double acc = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter initial account balance: ");

        double initialBalance = Double.parseDouble(scanner.nextLine());

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atmMachine = new ATM(userAccount);


        System.out.println("\nAccount No :" +acc);
        atmMachine.run();
    }
}
