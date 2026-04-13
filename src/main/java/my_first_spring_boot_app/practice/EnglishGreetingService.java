package my_first_spring_boot_app.practice;

public class EnglishGreetingService implements GreetingService{

   @Override
   public String greet(String name) {
      return "Hello, " + name + "! Welcome!";
   }
}
