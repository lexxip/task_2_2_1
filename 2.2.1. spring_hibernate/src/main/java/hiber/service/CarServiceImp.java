package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImp implements CarService {

   private final CarDao carDao;

   //   Могу отправить бином в конструктор
   public CarServiceImp(CarDao carDao) {
      this.carDao = carDao;
   }

   @Transactional
   @Override
   public void add(Car car) {
      carDao.add(car);
   }

}
