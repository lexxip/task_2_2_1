package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.Service;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

//      UserService userService = context.getBean(UserService.class);
      Service service = context.getBean(Service.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      service.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("Mersedes", 600));
      service.add(new User("User2", "Lastname2", "user2@mail.ru"), new Car("ГАЗ", 66));
      service.add(new User("User3", "Lastname3", "user3@mail.ru"), new Car("ВАЗ", 2108));
      service.add(new User("User4", "Lastname4", "user4@mail.ru"), new Car("Audi", 8));

//      List<User> users = userService.listUsers();
      List<User> users = service.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      Car car = new Car("Mersedes", 600);
      car.setId(1L);
      System.out.println("Пользователи владеющие машиной - " + car.getModel() + " " + car.getSeries());
      for (User user : service.getUserByCar(car)) {
         System.out.println(user);
      }

      context.close();
   }
}
