package my_first_spring_boot_app.students;

public class Student {

   private Long id;

   @NotBlank(message = "Name is required")
   @Size(min = 2, max = 100, message = "Name must be between 2 and 100 character")
   private String name;

   @NotBlank(message = "Email is required")
   @Email(message = "Email must be valid")
   private String email;

   @Min(value = 1, message = "Age must be at least 1")
   @Max(value = 150, message = "Age must be at most 150")
   private int age;

   public Student(Long id, String name, String email, int age) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.age = age;
   }

   //For JSON conversion
   public Student(){}

   //Getters and Setters

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   //toString for debugging
   @Override
   public String toString() {
      return "Student{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", email='" + email + '\'' +
              ", age=" + age +
              '}';
   }
}
