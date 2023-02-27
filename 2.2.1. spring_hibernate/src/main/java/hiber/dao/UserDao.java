package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
//   List<User> getUserByCar(Car car);
   List<User> listUsers();
   List<User> listUsers(Car car);
}
