package Encapsulation_Polymorphism_InterfaceandAbstractClass;

//BankingSystem.java

abstract class BankAccount {
	private String accountNumber;
	private String holderName;
	private double balance;

	public BankAccount(String number, String name, double balance) {
		this.accountNumber = number;
		this.holderName = name;
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount > 0)
			balance += amount;
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance)
			balance -= amount;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getBalance() {
		return balance;
	}

	public abstract double calculateInterest();
}

interface Loanable {
	void applyForLoan(double amount);

	boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
	public SavingsAccount(String number, String name, double balance) {
		super(number, name, balance);
	}

	@Override
	public double calculateInterest() {
		return getBalance() * 0.04;
	}

	@Override
	public void applyForLoan(double amount) {
		System.out.println("Loan applied: ₹" + amount);
	}

	@Override
	public boolean calculateLoanEligibility() {
		return getBalance() >= 10000;
	}
}

class CurrentAccount extends BankAccount {
	public CurrentAccount(String number, String name, double balance) {
		super(number, name, balance);
	}

	@Override
	public double calculateInterest() {
		return 0; // No interest
	}
}

public class BankingSystem {
	public static void main(String[] args) {
		BankAccount[] accounts = { new SavingsAccount("SB1001", "Govind", 25000),
				new CurrentAccount("CA2001", "Raj", 50000) };

		for (BankAccount acc : accounts) {
			System.out.println(acc.getHolderName() + " | Interest: ₹" + acc.calculateInterest());

			if (acc instanceof Loanable loan) {
				System.out.println("Loan Eligible: " + loan.calculateLoanEligibility());
				loan.applyForLoan(30000);
			}
			System.out.println("--------------------");
		}
	}
}
