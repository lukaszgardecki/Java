import java.util.ArrayList;

public class BookCollection implements Book {

  private final ArrayList<Book> books = new ArrayList<>();

  public void addBook(Book nonfictionBook) {
    books.add(nonfictionBook);
  }

  @Override
  public void checkout() {
    books.forEach(Book::checkout);
  }

  @Override
  public void returnBook() {
    books.forEach(Book::returnBook);
  }


}
