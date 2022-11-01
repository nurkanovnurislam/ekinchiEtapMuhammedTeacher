package peaksoft.dao;

import peaksoft.entity.Car;

import java.util.List;

public interface CarDao {

        void saveCar(Car car);

        Car getCarById(Long id);

        List<Car> getAllCars();

        void removeById(Long id);

        void creatTable();

        Car updateCar(Long id,Car car);
}
