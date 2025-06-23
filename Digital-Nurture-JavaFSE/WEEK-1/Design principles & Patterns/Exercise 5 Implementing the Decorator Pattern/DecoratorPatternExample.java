public class DecoratorPatternExample {
    interface Notifier {
        void send();
    }

    static class EmailNotifier implements Notifier {
        public void send() {
            System.out.println("Sending Email");
        }
    }

    static abstract class NotifierDecorator implements Notifier {
        protected Notifier notifier;
        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }
    }

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }
        public void send() {
            notifier.send();
            System.out.println("Sending SMS");
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }
        public void send() {
            notifier.send();
            System.out.println("Sending Slack Message");
        }
    }

    public static void main(String[] args) {
        Notifier n = new SMSNotifierDecorator(new SlackNotifierDecorator(new EmailNotifier()));
        n.send();
    }
}
