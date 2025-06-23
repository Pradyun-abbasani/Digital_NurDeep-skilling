import java.util.*;

public class EmployeeManagement {
    static class Employee {
        int id;
        String name;
        String position;
        double salary;

        public Employee(int id, String name, String position, double salary) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        void display() {
            System.out.println(id + " - " + name + " - " + position + " - " + salary);
        }
    }

    static class EmployeeArray {
        Employee[] arr = new Employee[100];
        int count = 0;

        void add(Employee emp) {
            arr[count++] = emp;
        }

        Employee search(int id) {
            for (int i = 0; i < count; i++) {
                if (arr[i].id == id) return arr[i];
            }
            return null;
        }

        void delete(int id) {
            for (int i = 0; i < count; i++) {
                if (arr[i].id == id) {
                    for (int j = i; j < count - 1; j++) arr[j] = arr[j + 1];
                    arr[--count] = null;
                    break;
                }
            }
        }

        void traverse() {
            for (int i = 0; i < count; i++) arr[i].display();
        }
    }

    public static void main(String[] args) {
        EmployeeArray system = new EmployeeArray();
        system.add(new Employee(1, "Pradyun", "HR", 500000));
        system.add(new Employee(2, "Jashwanth", "Clerk", 25000));

        system.traverse();

        System.out.println("Searching for ID 1:");
        Employee e = system.search(1);
        if (e != null) e.display();

        System.out.println("Deleting ID 2");
        system.delete(2);
        system.traverse();
    }
}
