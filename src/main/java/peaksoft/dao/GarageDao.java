package peaksoft.dao;

import peaksoft.entity.Car;
import peaksoft.entity.Garage;

import java.util.List;

public interface GarageDao {
    void saveGarage(Garage garage);

    Garage getGarageById(Long id);

    List<Garage> getAllGarage();

    void removeById(Long id);

    void creatTable();

    Car updateGarage(Long id,Garage garage);
}
