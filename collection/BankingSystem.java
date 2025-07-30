package collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BankingSystem {
    private Map<String, Double> accounts;
    private Queue<WithdrawalRequest> withdrawalQueue;

    public BankingSystem() {
        this.accounts = new HashMap<>(Map.of("ACC101", 5000.0, "ACC102", 1500.0, "ACC103", 12000.0));
        this.withdrawalQueue = new LinkedList<>();
    }

    public void processWithdrawals() {
        System.out.println("\nProcessing withdrawal requests...");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            accounts.computeIfPresent(request.getAccountNumber(), (acc, bal) -> bal - request.getAmount());
        }
    }

    public void displaySortedByBalance() {
        System.out.println("\n--- Customers sorted by balance (using stream sort) ---");
        LinkedHashMap<String, Double> sortedAccounts = new LinkedHashMap<>();
        accounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedAccounts.put(x.getKey(), x.getValue()));
        sortedAccounts.forEach((acc, bal) -> System.out.printf("Account: %s, Balance: $%.2f%n", acc, bal));
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        System.out.println("--- HashMap stores customer accounts ---");
        System.out.println("Initial accounts: " + bank.accounts);
        
        System.out.println("\n--- TreeMap sorts customers by account number ---");
        TreeMap<String, Double> sortedByAccount = new TreeMap<>(bank.accounts);
        System.out.println("Sorted accounts: " + sortedByAccount);
        
        bank.displaySortedByBalance();

        System.out.println("\n--- Queue processes withdrawal requests ---");
        bank.withdrawalQueue.add(new WithdrawalRequest("ACC103", 2000.0));
        bank.withdrawalQueue.add(new WithdrawalRequest("ACC101", 500.0));
        bank.processWithdrawals();
        System.out.println("Accounts after withdrawals: " + bank.accounts);
    }
}

class WithdrawalRequest {
    private final String accountNumber;
    private final double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}