import java.util.Scanner;

public class ATM {
    private static double balance = 0.0;
    private static final int PIN = 1234; // Example PIN
    private static int attempts = 3; // Number of allowed attempts

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // PIN authentication
        if (!authenticatePIN(scanner)) {
            System.out.println("Too many incorrect attempts. Exiting.");
            scanner.close();
            return;
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("ATM Interface:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static boolean authenticatePIN(Scanner scanner) {
        while (attempts > 0) {
            System.out.print("Enter your PIN: ");
            int enteredPIN = scanner.nextInt();

            if (enteredPIN == PIN) {
                System.out.println("PIN accepted. Access granted.");
                return true;
            } else {
                attempts--;
                System.out.println("Incorrect PIN. You have " + attempts + " attempts remaining.");
            }
        }
        return false;
    }

    private static void checkBalance() {
        System.out.printf("Current balance: $%.2f%n", balance);
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f%n", amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f%n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }
}