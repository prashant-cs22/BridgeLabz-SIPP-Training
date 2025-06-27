package objectModeling;

class Bank {
	String name;
	
	Bank(String name) {
		this.name = name;
	}
	
	void openAccount(Customer customer) {
		customer.setBank(this);
		System.out.println(customer.name + " created an account in the bank " + this.name);
	}
}

class Customer {
	String name;
	String bank;
	double balance;
	
	Customer(String name) {
		this.name = name;
	}
	
	void setBank(Bank bank) {
		this.bank = bank.name;
	}
	
	void displayBalance() {
		System.out.println("Account balance: " + balance);
	}
}

public class Bank_association {

	public static void main(String[] args) {
		Bank bank1 = new Bank("SBI");
		Customer customer1 = new Customer("Govind");
		
		bank1.openAccount(customer1);
		customer1.balance = 10000;
		customer1.displayBalance();
	}

}
