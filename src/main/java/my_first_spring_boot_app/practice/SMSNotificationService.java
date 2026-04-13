package my_first_spring_boot_app.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("sms")
public class SMSNotificationService implements NotificationService{

   @Override
   public void sendNotification(String message) {
      System.out.println("SMS: " + message);
   }
}
