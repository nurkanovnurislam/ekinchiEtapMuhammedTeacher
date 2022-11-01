package peaksoft.service;

import peaksoft.dao.CarDao;
import peaksoft.dao.CarDaoImpl;
import peaksoft.entity.Car;

public class CarServiceImpl implements CarService {
    CarDao carDao = new CarDaoImpl();

    @Override
    public void saveCar(Car car) {
        carDao.saveCar(car);
    }

    @Override
    public Car getCarById(Long id) {
        return carDao.getCarById(id);
    }

    @Override
    public Car getAllCars() {
        return (Car) carDao.getAllCars();
    }

    @Override
    public void removeById(Long id) {
        carDao.removeById(id);
    }

    @Override
    public void creatTable() {
        carDao.creatTable();
    }

    @Override
    public Car updateCar(Long id, Car car) {
        return null;
    }
}
