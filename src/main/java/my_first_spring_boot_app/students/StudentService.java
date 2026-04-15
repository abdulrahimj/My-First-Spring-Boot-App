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
      return studentRepository.save(student);
   }

   public Student updateStudent(Long id, Student updatedStudent) {
      //check if student exists
      getStudentById(id);
      return studentRepository.update(id, updatedStudent);
   }

   public boolean deleteStudent(Long id) {
      //First, check if student exists
      getStudentById(id); //Throws if not found
      return studentRepository.deleteById(id);
   }
}
