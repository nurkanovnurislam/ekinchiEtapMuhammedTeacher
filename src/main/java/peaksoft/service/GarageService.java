package peaksoft.service;

import peaksoft.entity.Car;
import peaksoft.entity.Garage;

import java.util.List;

public interface GarageService {
    void saveGarage(Garage garage);

    Garage getGarageById(Long id);

    Garage getAllGarage();

    void removeById(Long id);

    void creatTable();

    Car updateGarage(Long id, Garage garage);
}
