package chapter_7;

import structures.LinkedList;

/**
 * Online Book Reader
 *
 * Design the data structures for an online book reader system
 *
 */
public class Task_5 {
    public static void main(String[] args) { }

    public class Store {
        LinkedList<Book> availableBooks;

        public Book find(String query) { return availableBooks.getLast(); }

        public void buy(User user, Book book) {
            // purchase book
        }
    }

    public class User {
        LinkedList<Book> purchasedBooks;
    }

    public class Book {
        private String title;
        private String author;
    }

    // for device
    public class Display {
        private Book book;
        private User activeUser;
        private int pageNumber = 0;

        public void turnPageForward() {
            pageNumber++;
            refreshPage();
        }

        public void turnPageBackward() {
            pageNumber--;
            refreshPage();
        }

        public void refreshPage() {}
    }
}