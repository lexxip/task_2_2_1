package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImp implements hiber.service.Service {

   @Autowired
   private CarService carService;
   @Autowired
   private UserService userService;

   @Override
   public void add(User user, Car car) {
      user.setCar(car);
      carService.add(car);
      userService.add(user);
   }

   @Override
   public List<User> getUserByCar(Car car) {
      return userService.getUserbyCar(car);
   }

   @Override
   public List<User> listUsers() {
      return userService.listUsers();
   }

}
