import java.util.*;

public class ObserverPatternExample {
    interface Observer {
        void update(String stockName, double price);
    }

    interface Stock {
        void register(Observer o);
        void deregister(Observer o);
        void notifyObservers();
    }

    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double price;

        public void setStock(String stockName, double price) {
            this.stockName = stockName;
            this.price = price;
            notifyObservers();
        }

        public void register(Observer o) {
            observers.add(o);
        }

        public void deregister(Observer o) {
            observers.remove(o);
        }

        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(stockName, price);
            }
        }
    }

    static class MobileApp implements Observer {
        public void update(String stockName, double price) {
            System.out.println("Mobile App: " + stockName + " updated to " + price);
        }
    }

    static class WebApp implements Observer {
        public void update(String stockName, double price) {
            System.out.println("Web App: " + stockName + " updated to " + price);
        }
    }

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.register(mobile);
        stockMarket.register(web);

        stockMarket.setStock("Oppo", 172.5);
        stockMarket.setStock("Google", 2845.0);
    }
}
