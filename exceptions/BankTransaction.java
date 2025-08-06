package exceptions;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        System.out.println("Attempting to withdraw: " + amount);
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount: Withdrawal amount cannot be negative.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Available: " + balance + ", Requested: " + amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }
}

public class BankTransaction {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        System.out.println("Initial balance: " + account.getBalance());

        try {
            account.withdraw(500.00);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.err.println("Transaction failed: " + e.getMessage());
        }
        
        System.out.println("\n--------------------------\n");

        try {
            account.withdraw(600.00);
        } catch (InsufficientBalanceException e) {
            System.err.println("Transaction failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Transaction failed with invalid argument: " + e.getMessage());
        }

        System.out.println("\n--------------------------\n");

        try {
            account.withdraw(-100.00);
        } catch (InsufficientBalanceException e) {
            System.err.println("Transaction failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Transaction failed with invalid argument: " + e.getMessage());
        }
        
        System.out.println("\nFinal balance: " + account.getBalance());
    }
}
