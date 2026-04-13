package my_first_spring_boot_app.students;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

   //our database - just a List
   private List<Student> students = new ArrayList<>();
   private Long nextId = 1L; //Auto-increment ID

   //constructor: add some dummy data
   public StudentRepository() {
      students.add(new Student(nextId++, "Alice", "alice@gmail.com", 20));
      students.add(new Student(nextId++, "Bob", "bob@gmail.com", 22));
      students.add(new Student(nextId++, "Charlie", "charlie@gmail.com", 21));
   }

   //Get all students
   public List<Student> findAll() {
      return students;
   }

   //get student by id
   public Optional<Student> findById(Long id) {
      return students.stream()
              .filter(student -> student.getId().equals(id))
              .findFirst();
   }

   //save a new student
   public Student save(Student student) {
      student.setId(nextId++);
      students.add(student);
      return student;
   }

   //update a student
   public Student update(Long id, Student updatedStudent) {
      Optional<Student> existingStudent = findById(id);
      if (existingStudent.isPresent()) {
         Student student = existingStudent.get();
         student.setName(updatedStudent.getName());
         student.setEmail(updatedStudent.getEmail());
         student.setAge(updatedStudent.getAge());
         return student;
      }
      return null;
   }

   //delete a student
   public boolean deleteById(Long id) {
      return students.removeIf(student -> student.getId().equals(id));
   }
}
