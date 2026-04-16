package my_first_spring_boot_app.books;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Book {

   private Long id;
   
   @NotBlank(message = "Title is required")
   @Size(min = 1, max = 200, message = "Tile must be between 1 to 200 characters")
   private String title;

   @NotBlank(message = "Author is required")
   private String author;

   @NotBlank(message = "ISBN is required")
   @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
   private String isbn;

   @Positive(message = "Price must be greater than zero")
   private double price;

   public Book(Long id, String title, String author, String isbn, double price) {
      this.id = id;
      this.title = title;
      this.author = author;
      this.isbn = isbn;
      this.price = price;
   }

   public Book() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public String getIsbn() {
      return isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   @Override
   public String toString() {
      return "Book{" +
              "id=" + id +
              ", title='" + title + '\'' +
              ", author='" + author + '\'' +
              ", isbn='" + isbn + '\'' +
              ", price=" + price +
              '}';
   }
}
