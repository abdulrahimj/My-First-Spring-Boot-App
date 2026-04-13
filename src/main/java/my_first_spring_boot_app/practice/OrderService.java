package my_first_spring_boot_app.practice;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

   private final PaymentMethod paymentMethod;

   //One constructor? -> @Autowired is optional
   public OrderService (PaymentMethod paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public String placeOrder(String item, double price) {
      String paymentResult = paymentMethod.pay(price);
      return "Order placed for " + item + ". " + paymentResult;
   }
}
