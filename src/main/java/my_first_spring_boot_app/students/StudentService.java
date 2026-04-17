package my_first_spring_boot_app.students;

import my_first_spring_boot_app.BadRequestException;
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

      //Check if email already exists
      if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
         throw new BadRequestException(
                 "Email " + student.getName() + " is already taken");
      }

      return studentRepository.save(student);
   }

   public Student updateStudent(Long id, Student updatedStudent) {
      //check if student exists
      Student existingStudent = getStudentById(id);

      //Update fields
      existingStudent.setName(updatedStudent.getName());
      existingStudent.setEmail(updatedStudent.getEmail());
      existingStudent.setAge(updatedStudent.getAge());

      return studentRepository.save(existingStudent);
   }

   public void deleteStudent(Long id) {
      //First, check if student exists
      getStudentById(id); //Throws if not found
      studentRepository.deleteById(id);
   }

   //Search students by name
   public List<Student> searchByName(String name) {
      return studentRepository.findByNameContaining(name);
   }
}
