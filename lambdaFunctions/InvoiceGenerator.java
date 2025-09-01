package lambdaFunctions;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class InvoiceGenerator {

    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("TXN987", "TXN654", "TXN321");

        List<Invoice> invoices = new ArrayList<>();
        for (String id : transactionIds) {
            invoices.add(new Invoice(id));
        }

        System.out.println("Generated invoice objects: " + invoices);
    }

    static class Invoice {
        private String transactionId;
        public Invoice(String transactionId) {
            this.transactionId = transactionId;
        }

        @Override
        public String toString() {
            return "Invoice[" + transactionId + "]";
        }
    }
}

