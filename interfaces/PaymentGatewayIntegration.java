package interfaces;

interface PaymentProcessor {
    void process(double amount);
    default void refund(double amount) {
        System.out.println("Refunding " + amount);
    }
}

class PayPal implements PaymentProcessor {
    public void process(double amount) { System.out.println("Processed via PayPal: " + amount); }
}

public class PaymentGatewayIntegration {
    public static void main(String[] args) {
        PaymentProcessor p = new PayPal();
        p.process(1000);
        p.refund(500);
    }
}
