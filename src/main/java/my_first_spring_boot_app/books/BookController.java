package my_first_spring_boot_app.books;

import jakarta.validation.Valid;
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
   public Book getBookById(@PathVariable Long id) {
     return bookService.getBookById(id);
   }

   //Post a book - /api/books
   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public Book createBook(@Valid @RequestBody Book book) {
      return bookService.createBook(book);
   }

   //Put a book - /api/books/3
   @PutMapping("/{id}")
   public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
      return bookService.updateBook(id, book);
   }

   //Delete a book - /api/books/3
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void deleteBook(@PathVariable Long id) {
     bookService.deleteBook(id);
   }
}
