package my_first_spring_boot_app.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   NotificationService notificationService;

   @Autowired
   public UserService(@Qualifier("email") NotificationService notificationService) {
      this.notificationService = notificationService;
   }

   public void registerUser(String userName) {
      System.out.println("User " + userName + " registered!");
      notificationService.sendNotification("Welcome, " + userName);
   }
}
