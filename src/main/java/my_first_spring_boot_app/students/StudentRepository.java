package my_first_spring_boot_app.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

   //Custom query: Find student by Email
   Optional<Student> findByEmail(String email);

   List<Student> findByNameContaining(String name);
}
