package constructorsAndAccessSpecifiers;

class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
    }

    void displayDetails() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Balance: ₹" + this.balance);
    }
}

class SavingsAccount extends BankAccount {

    private double interestRate;

    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void displaySavingsDetails() {
        System.out.println("Savings Account");
        System.out.println("Account Number: " + this.accountNumber);   // public
        System.out.println("Account Holder: " + this.accountHolder);   // protected
        System.out.println("Interest Rate: " + this.interestRate + "%");
    }
}

public class BankAccountSystem {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount("1234567890", "Govind", 15000);
        ba.displayDetails();
        System.out.println();

        ba.deposit(5000);
        ba.withdraw(2000);
        System.out.println("Updated Balance: ₹" + ba.getBalance());
        System.out.println();

        SavingsAccount sa = new SavingsAccount("9876543210", "Aryan", 10000, 5.0);
        sa.deposit(5000);
        sa.displaySavingsDetails();
    }
}
