package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private UserDao userDao;
   private CarService carService;

   //   Могу заавтовайрить метод
   @Autowired
   public void addOtherServices(UserDao userDao, CarService carService) {
      this.userDao = userDao;
      this.carService = carService;
   }

   @Transactional
   @Override
   public void add(User user) {
      carService.add(user.getCar());
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getUserbyCar(Car car) {
      return userDao.listUsers(car);
   }

}
