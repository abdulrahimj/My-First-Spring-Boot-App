package my_first_spring_boot_app.books;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

   private List<Book> books = new ArrayList<>();
   private Long nextId = 1L;

   public BookRepository() {
      books.add(new Book(nextId++, "Quran", "Allah", "9780132350884",  0.00));
      books.add(new Book(nextId++, "Sahih Bukhari", "Imam Bukhari","9780201616224", 15.00));
      books.add(new Book(nextId++, "Sahih Muslim", "Imam Muslim", "9781617292545", 10.00));
   }

   //Get all books
   public List<Book> findAll() {
      return books;
   }

   //Get a single book by ID
   public Optional<Book> findById(Long id) {
      return books.stream()
              .filter(book -> book.getId().equals(id))
              .findFirst();
   }
   
   //check if ISBN already exists
   public boolean existsByIsbn(String isbn) {
      return books.stream()
              .anyMatch(book -> book.getIsbn().equals(isbn));
   }

   //save a new book
   public Book save(Book book) {
      book.setId(nextId);
      books.add(book);
      return book;
   }

   //Update a book
   public Book update(Long id, Book updatedBook) {
      Optional<Book> existingBook = findById(id);
      if (existingBook.isPresent()) {
         Book book = existingBook.get();
         book.setTitle(updatedBook.getTitle());
         book.setAuthor(updatedBook.getAuthor());
         book.setIsbn(updatedBook.getIsbn());
         book.setPrice(updatedBook.getPrice());
         return book;
      }
      return null;
   }

   //Delete a book
   public boolean deleteById(Long id) {
      return books.removeIf(book -> book.getId().equals(id));
   }
}
