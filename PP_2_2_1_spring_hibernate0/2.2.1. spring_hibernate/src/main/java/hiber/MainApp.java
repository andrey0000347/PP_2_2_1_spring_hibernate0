package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      // Создание и добавление автомобилей
      Car car1 = new Car(1, "Toyota");
      Car car2 = new Car(2, "Honda");
      Car car3 = new Car(3, "BMW");

      userService.add(new User("Alex", "Lastname1", "user1@mail.ru"), car1);
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"), car2);
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"), car3);

      // Получение и вывод списка пользователей
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
     }

      context.close();
   }
}
