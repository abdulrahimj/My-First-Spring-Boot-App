package my_first_spring_boot_app.books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

   private final BookService bookService;

   public BookController(BookService bookService) {
      this.bookService = bookService;
   }

   //Get all books - /api/books
   @GetMapping
   public List<Book> getAllBooks() {
      return bookService.getAllBooks();
   }

   //Get one book by ID - /api/books/2
   @GetMapping("/{id}")
   public ResponseEntity<Book> getBookById(@PathVariable Long id) {
     Optional<Book> book = bookService.getBookById(id);
     if (book.isPresent()) {
        return ResponseEntity.ok(book.get());
     } else {
        return ResponseEntity.notFound().build();
     }
   }

   //Post a book - /api/books
   @PostMapping
   public ResponseEntity<Book> createBook(@RequestBody Book book) {
      Book newBook = bookService.createBook(book);
      return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
   }

   //Put a book - /api/books/3
   @PutMapping("/{id}")
   public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
      Book updatedBook = bookService.updateBook(id, book);

      if (updatedBook != null) {
         return ResponseEntity.ok(updatedBook);
      } else {
         return ResponseEntity.notFound().build();
      }
   }

   //Delete a book - /api/books/3
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
     boolean deletedBook = bookService.deleteBook(id);

     if (deletedBook) {
        return ResponseEntity.noContent().build();
     } else {
        return ResponseEntity.notFound().build();
     }
   }
}
