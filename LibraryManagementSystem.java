import java.util.ArrayList;
import java.util.Scanner;

class Book 
{
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }
}

public class LibraryManagementSystem {

    private static ArrayList<Book> books = new ArrayList<>();

    public static void addBook(String title, String author, String isbn) {
        Book newBook = new Book(title, author, isbn);
        books.add(newBook);
        System.out.println("Book added successfully.");
    }

    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("List of Books in Library:");
            for (Book book : books) {
                book.displayBookDetails();
            }
        }
    }

    public static void searchBookByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayBookDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }

    public static void removeBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Book removed successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. Display all books");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Remove a book by title");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    addBook(title, author, isbn);
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    searchBookByTitle(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    removeBook(removeTitle);
                    break;

                case 5:
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}

