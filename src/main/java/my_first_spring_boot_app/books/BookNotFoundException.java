package my_first_spring_boot_app.books;

public class BookNotFoundException extends RuntimeException{

   //When searching by ID
   public BookNotFoundException(Long id) {
      super("Book with ID " + id + " not found");
   }

   //When searching by ISBN
   public BookNotFoundException(String isbn) {
      super("Book with ISBN " + isbn + " not found");
   }
}
