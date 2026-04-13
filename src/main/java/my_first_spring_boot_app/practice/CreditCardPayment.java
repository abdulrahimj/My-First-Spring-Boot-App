package my_first_spring_boot_app.practice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditCardPayment implements PaymentMethod {

   @Override
   public String pay(double amount) {
      return "Paid $" + amount + " with Credit Card";
   }
}
