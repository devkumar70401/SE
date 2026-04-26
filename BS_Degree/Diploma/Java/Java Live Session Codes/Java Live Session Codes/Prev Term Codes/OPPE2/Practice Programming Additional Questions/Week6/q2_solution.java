package week6;


import java.util.*;

class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String genre;

    public Book(String title, String author, int publicationYear, String genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getGenre() {
        return genre;
    }
   
    // Implement the toString method as required by the output
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", genre='" + genre + '\'' +
                '}';
    }
}

class Library {

    // private instance variable 'books'
    private HashMap<String, Book> books;

    //complete the constructor to initialise the instance variable
    public Library() {
        this.books = new LinkedHashMap<String, Book>();
    }

    public void addBook(Book book) {
        String key = book.getTitle() + "-" + book.getAuthor();
        books.put(key, book);
    }

    // return the list of books in the specific genre 
    public List<Book> searchByGenre(String genre) {
        List<Book> booksByGenre = new ArrayList<Book>();

        //method 1
        for(Map.Entry<String,Book> entry : books.entrySet()){
            Book book = entry.getValue();
            if(book.getGenre().equals(genre)){
                booksByGenre.add(book);
            }
        }
        
        // method 2
        for(Book book : books.values()){
            if(book.getGenre().equals(genre)){
                booksByGenre.add(book);
            }
        }

        return booksByGenre;
    }

    public void displayBooksByGenre(String genre){
        List<Book> filteredBooks = searchByGenre(genre);

        // method 1
        for(Book book : filteredBooks){
            System.out.println(book);
        }

        // method 2
        Iterator<Book> bookIterator = filteredBooks.iterator();
        while(bookIterator.hasNext()){
            System.out.println(bookIterator.next());
        }
    }
}

public class BooksQuestion {

    public static void main(String[] args) {
        Library library = new Library();

        // Add books (including duplicates) - only unique will be stored
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "Fantasy"));
        library.addBook(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, "Science Fiction"));
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "Fantasy"));
        library.addBook(new Book("The Martian", "Andy Weir", 2011, "Science Fiction"));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", 1813, "Fiction"));

        // Search by genre
        List<Book> fantasyBooks = library.searchByGenre("Fantasy");

        // Print search results
        System.out.println("\nList of books in the Fantasy genre:");
        for (Book book : fantasyBooks) {
            System.out.println("- " + book);
        }
    }
}


