import java.util.*;

public class SortOrders {
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        void display() {
            System.out.println(orderId + " - " + customerName + " - " + totalPrice);
        }
    }

    static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Order[] orders = {
            new Order(101, "Pradyun", 2500),
            new Order(200, "Rohan", 1800),
            new Order(380, "Jashwanth", 3200),
            new Order(457, "Trivedh", 4300),
            new Order(555, "Hemanth", 2000)
        };
 
        Order[] bubbleOrders = Arrays.copyOf(orders, orders.length);
        Order[] quickOrders = Arrays.copyOf(orders, orders.length);

        System.out.println("Sorting using Bubble Sort:");
        bubbleSort(bubbleOrders);
        for (Order o : bubbleOrders) o.display();

        System.out.println("\nSorting using Quick Sort:");
        quickSort(quickOrders, 0, quickOrders.length - 1);
        for (Order o : quickOrders) o.display();
    }
}
