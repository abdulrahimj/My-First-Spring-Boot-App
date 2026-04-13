package my_first_spring_boot_app.practice;

import org.springframework.stereotype.Service;

@Service
public class SpanishGreetingService implements GreetingService{

   @Override
   public String greet(String name) {
      return "!Hola, " + name + "! Bienvenido!";
   }
}
