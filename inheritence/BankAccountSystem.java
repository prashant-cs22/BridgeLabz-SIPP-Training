package inheritence;

class BankAccount {
	int accountNumber;
	double balance;
	
	BankAccount(int accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	void displayAccountType() {
		System.out.println("Some account");
	}
}

class SavingsAccount extends BankAccount {
	float interestRate;
	
	SavingsAccount(int accountNumber, double balance, float interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}
	
	@Override
	void displayAccountType() {
		System.out.println("This is a Savings account.");
	}
}

class CheckingAccount extends BankAccount {
	double withdrawalLimit;
	
	CheckingAccount(int accountNumber, double balance, float withdrawalLimit) {
		super(accountNumber, balance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	@Override
	void displayAccountType() {
		System.out.println("This is a checking account.");
	}
}

class FixedDipositeAccount extends BankAccount {
	int tenure;
	
	FixedDipositeAccount(int accountNumber, double balance, int tenure) {
		super(accountNumber, balance);
		this.tenure = tenure;
	}
	
	@Override
	void displayAccountType() {
		System.out.println("This is a fixed diposite account.");
	}
}

public class BankAccountSystem {

	public static void main(String[] args) {
		BankAccount[] accounts = {
				new SavingsAccount(01, 20000, 12),
				new CheckingAccount(01, 40000, 15000),
				new FixedDipositeAccount(03, 50000, 5)
		};
		
		for(BankAccount account: accounts) {
			account.displayAccountType();
		}
	}

}
