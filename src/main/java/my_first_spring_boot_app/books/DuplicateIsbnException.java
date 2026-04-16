package my_first_spring_boot_app.books;

public class DuplicateIsbnException extends RuntimeException{

   public DuplicateIsbnException(String isbn) {
      super("Book with ISBN " + isbn + " already exists");
   }
}
