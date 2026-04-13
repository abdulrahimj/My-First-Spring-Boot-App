package my_first_spring_boot_app.students;

public class StudentNotFoundException extends RuntimeException {

   public StudentNotFoundException(Long id) {
      super("Student with ID " + id + " not found");
   }

   public StudentNotFoundException(String message) {
      super(message);
   }
}
