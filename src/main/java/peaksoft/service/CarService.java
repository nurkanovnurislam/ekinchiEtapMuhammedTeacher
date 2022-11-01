package peaksoft.service;

import peaksoft.entity.Car;

public interface CarService {
    void saveCar(Car car);

    Car getCarById(Long id);

    Car getAllCars();

    void removeById(Long id);

    void creatTable();

    Car updateCar(Long id,Car car);
}
