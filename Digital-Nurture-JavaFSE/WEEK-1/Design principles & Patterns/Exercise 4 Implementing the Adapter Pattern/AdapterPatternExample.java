public class AdapterPatternExample {
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    static class PayPalGateway {
        void sendMoney(double amt) {
            System.out.println("PayPal processed: " + amt);
        }
    }

    static class StripeGateway {
        void makePayment(double amt) {
            System.out.println("Stripe processed: " + amt);
        }
    }

    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway gateway = new PayPalGateway();
        public void processPayment(double amount) {
            gateway.sendMoney(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway gateway = new StripeGateway();
        public void processPayment(double amount) {
            gateway.makePayment(amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor p1 = new PayPalAdapter();
        PaymentProcessor p2 = new StripeAdapter();
        p1.processPayment(100000);
        p2.processPayment(250);
    }
}
