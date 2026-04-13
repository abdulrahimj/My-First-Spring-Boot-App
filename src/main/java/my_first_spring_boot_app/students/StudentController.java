package my_first_spring_boot_app.students;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

   private final StudentService studentService;

   //constructure injection
   public StudentController(StudentService studentService) {
      this.studentService = studentService;
   }

   //GET /api/students - Get all students
   @GetMapping
   public List<Student> getAllStudents() {
      return studentService.getAllStudents();
   }

   //GET /api/students/1 - Get student by ID
   @GetMapping("/{id}")
   public Student getStudentById(@PathVariable Long id) {
      //If not found, Service throws StudentNotFoundException
      //GlobalExceptionHandler catches it and returns a proper error
      return studentService.getStudentById(id);
   }

   //POST /api/students - Create new student
   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)   //Returns 201 on success
   public Student createStudent(@RequestBody Student student) {
      return studentService.createStudent(student);
   }

   //PUT /api/students/1 - Update student
   @PutMapping("/{id}")
   public Student updateStudent(
           @PathVariable Long id,
           @RequestBody Student student) {
      return studentService.updateStudent(id, student);
   }

   //DELETE /api/students/1 - Delete student
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)  //Returns 204 on success
   public void deleteStudent(@PathVariable Long id) {
      studentService.deleteStudent(id);
   }
}
