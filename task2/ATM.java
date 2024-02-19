package task2;

import java.util.Scanner;

public class ATM implements ATMInterface {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= bankAccount.getBalance()) {
            bankAccount.withdraw(amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            bankAccount.deposit(amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Balance: $" + bankAccount.getBalance());
    }

    public void displayMenu() {
        System.out.println("\n==== ATM Menu ====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter option (1-4): ");
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance for the user
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

