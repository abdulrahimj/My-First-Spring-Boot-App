package my_first_spring_boot_app.books;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

   private final BookRepository bookRepository;

   public BookService(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
   }

   //Get all books
   public List<Book> getAllBooks() {
      return bookRepository.findAll();
   }

   //Get a book by ID
   public Optional<Book> getBookById(Long id) {
      return bookRepository.findById(id);
   }

   //Create a new book
   public Book createBook(Book book) {
      return bookRepository.save(book);
   }

   //Update a book
   public Book updateBook(Long id, Book updateBook) {
      return bookRepository.update(id, updateBook);
   }

   //Delete a book
   public boolean deleteBook(Long id) {
      return bookRepository.deleteById(id);
   }
}
