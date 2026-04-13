package my_first_spring_boot_app.practice;

public class BitcoinPayment implements PaymentMethod{

   public String pay(double amount) {
      return "Paid $" + amount + " with Bitcoin";
   }
}
