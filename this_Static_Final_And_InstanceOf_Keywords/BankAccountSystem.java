package this_Static_Final_And_InstanceOf_Keywords;

class BankAccount {
    static String bankName = "Secure Bank";
    private static int totalAccounts = 0;

    private final int accountNumber;
    private String accountHolderName;

    public BankAccount(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Bank Name: " + bankName);
        }
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(1001, "Alice");
        BankAccount acc2 = new BankAccount(1002, "Bob");

        acc1.displayDetails();
        System.out.println();
        acc2.displayDetails();
        System.out.println();

        BankAccount.getTotalAccounts();
    }
}
