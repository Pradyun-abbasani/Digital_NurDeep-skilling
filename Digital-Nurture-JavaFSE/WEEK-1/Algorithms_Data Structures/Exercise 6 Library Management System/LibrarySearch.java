import java.util.*;
 

public class LibrarySearch {
    static class Book implements Comparable<Book> {
        int id;
        String title;
        String author;

        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        public int compareTo(Book b) {
            return this.title.compareToIgnoreCase(b.title);
        }

        void display() {
            System.out.println(id + " - " + title + " by " + author);
        }
    }

    static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = {
            new Book(101, "Harry Potter", "J.K.Rowling"),
            new Book(102, "Data Structures", "John"),
            new Book(103, "The God of Small Things", "Arundhati Roy"),
            new Book(104, "Treasure Island", "Robert Louis Stevenson ")
        };

        //System.out.print("Enter book title to search (Linear Search): ");
        String title1 = sc.nextLine();
        Book found = linearSearch(books, title1);
        if (found != null) found.display();
        else System.out.println("Book not found");

        Arrays.sort(books);

        //System.out.print("Enter book title to search (Binary Search): ");
        String title2 = sc.nextLine();
        Book b2 = binarySearch(books, title2);
        if (b2 != null) b2.display();
        else System.out.println("Book not found");
    }
}
