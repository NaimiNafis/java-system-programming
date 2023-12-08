package jx08;
import java.io.*;

public class BookModel {
    private final String filename = "book.txt";

    public void addBook(String title, String author, String publisher, String isbn) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)))) {
        	out.println(title + "; " + author + "; " + publisher + "; " + isbn);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public String listBooks() {
        StringBuilder books = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.append(line).append("\n\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return books.toString();
    }

    public String searchBooks(String searchText) {
        StringBuilder foundBooks = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchText)) {
                    foundBooks.append(line).append("\n\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return foundBooks.toString();
    }
}


