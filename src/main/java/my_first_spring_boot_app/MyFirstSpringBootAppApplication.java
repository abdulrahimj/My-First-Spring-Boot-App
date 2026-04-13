package my_first_spring_boot_app;

import my_first_spring_boot_app.practice.GreetingService;
import my_first_spring_boot_app.practice.OrderService;
import my_first_spring_boot_app.practice.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFirstSpringBootAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MyFirstSpringBootAppApplication.class, args);

		System.out.println("\n=======USING BEANS=======");
		//Get beans from spring's container
		OrderService orderService = context.getBean(OrderService.class);
		GreetingService greetingService = context.getBean(GreetingService.class);
		UserService userService = context.getBean(UserService.class);

		//Use them
		System.out.println(orderService.placeOrder("Laptop", 999.99));
		System.out.println(greetingService.greet("Abdulrahim"));
		userService.registerUser("Alice");
	}

}
