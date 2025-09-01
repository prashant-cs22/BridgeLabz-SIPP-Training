package streamAPI;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class LoggingTransactions {
 public static void main(String[] args) {
     List<String> transactionIds = Arrays.asList("TRX-001", "TRX-002", "TRX-003");

     transactionIds.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction: " + id));
 }
}