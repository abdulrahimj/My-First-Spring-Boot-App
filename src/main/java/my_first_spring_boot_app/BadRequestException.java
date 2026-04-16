package my_first_spring_boot_app;

public class BadRequestException extends RuntimeException {

   public BadRequestException(String message) {
      super(message);
   }
}
