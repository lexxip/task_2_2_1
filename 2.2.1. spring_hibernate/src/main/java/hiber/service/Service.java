package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface Service {
    void add(User user, Car car);
    List<User> getUserByCar(Car car);
    List<User> listUsers();
}
