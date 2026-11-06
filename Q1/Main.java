import java.util.Scanner;
public class Main {
    static double balance = 10000;
    static void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "Amount must be greater than zero");
            }
            // First check balance
            if (amount > balance) {
                throw new IllegalArgumentException(
                        "Insufficient balance");
            }
            // Withdraw money
            balance = balance - amount;
            System.out.println("Withdrawal successful");
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Remaining balance: " + balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Transaction failed: "
                    + e.getMessage());
        } finally {
            System.out.println("ATM transaction completed.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter account number: ");
            String account = sc.nextLine();
            System.out.print("Enter withdrawal amount: ");
            double amount = Double.parseDouble(sc.nextLine());
            System.out.println("Current balance: " + balance);
            withdraw(amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Enter a number.");
        } finally {
            sc.close();
        }
    }
}
