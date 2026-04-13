package my_first_spring_boot_app.students;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

   //Handle StudentNotFoundException
   @ExceptionHandler(StudentNotFoundException.class)
   public ResponseEntity<ErrorResponse> handleStudentNotFound(
           StudentNotFoundException ex,
           WebRequest request) {

      ErrorResponse error = new ErrorResponse(
              HttpStatus.NOT_FOUND.value(),
              "Not Found",
              ex.getMessage(),
              request.getDescription(false)
      );

      return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
   }

   //Handle BadRequestException
   @ExceptionHandler(BadRequestException.class)
   public ResponseEntity<ErrorResponse> handleBadRequest(
           BadRequestException ex,
           WebRequest request) {

      ErrorResponse error = new ErrorResponse(
              HttpStatus.BAD_REQUEST.value(),
              "Bad Request",
              ex.getMessage(),
              request.getDescription(false)
      );

      return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
   }

   //Handle ALL other exception (catch-all)
   @ExceptionHandler(Exception.class)
   public ResponseEntity<ErrorResponse> handleAllException(
           Exception ex,
           WebRequest request) {

      ErrorResponse error = new ErrorResponse(
              HttpStatus.INTERNAL_SERVER_ERROR.value(),
              "Internal Server Error",
              "Something went wrong. Please try again later.",
              request.getDescription(false)
      );

      // Log the actual error for debugging (we'll learn logging later)
      System.err.println("Unexpected error: " + ex.getMessage());
      ex.printStackTrace();

      return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
