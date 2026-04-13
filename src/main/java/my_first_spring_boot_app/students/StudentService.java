package my_first_spring_boot_app.students;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

   private final StudentRepository studentRepository;

   //constructor injection
   public StudentService(StudentRepository studentRepository) {
      this.studentRepository = studentRepository;
   }

   public List<Student> getAllStudents() {
      return studentRepository.findAll();
   }

   public Student getStudentById(Long id) {
      return studentRepository.findById(id)
              .orElseThrow(() -> new StudentNotFoundException(id));
   }

   public Student createStudent(Student student) {
      //Validate input
      if (student.getName() == null || student.getName().trim().isEmpty()) {
         throw new BadRequestException("Student name cannot be empty");
      }
      if (student.getEmail() == null || student.getEmail().trim().isEmpty()) {
         throw new BadRequestException("Student email cannot be empty");
      }
      return studentRepository.save(student);
   }

   public Student updateStudent(Long id, Student updatedStudent) {
      //First, check if student exists
      Student existingStudent = getStudentById(id);  //Throws if not found

      //Update the student
      return studentRepository.update(id, updatedStudent);
   }

   public boolean deleteStudent(Long id) {
      //First, check if student exists
      getStudentById(id); //Throws if not found

      return studentRepository.deleteById(id);
   }
}
