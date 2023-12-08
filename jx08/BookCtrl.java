package jx08;

public class BookCtrl {
    private final BookModel model;

    public BookCtrl(BookModel model) {
        this.model = model;
    }

    public void registerBook(String title, String author, String publisher, String isbn) {
        model.addBook(title, author, publisher, isbn);
    }

    public String listBooks() {
        return model.listBooks();
    }

    public String searchBook(String searchText) {
        return model.searchBooks(searchText);
    }
}


