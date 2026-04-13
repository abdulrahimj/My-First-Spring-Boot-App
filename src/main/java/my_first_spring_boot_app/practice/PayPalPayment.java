package my_first_spring_boot_app.practice;

public class PayPalPayment implements PaymentMethod {

   @Override
   public String pay(double amount) {
      return "Paid $" + amount + " with PayPal";
   }
}
