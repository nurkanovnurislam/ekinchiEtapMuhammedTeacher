package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.Config;
import peaksoft.entity.Car;

import java.util.List;

public class CarDaoImpl implements CarDao {
    SessionFactory sessionFactory = Config.getSessionFactory();

    @Override
    public void saveCar(Car car) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(car);
        System.out.println("koshuldu");
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Car getCarById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Car car = session.find(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    @Override
    public List<Car> getAllCars() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<Car> cars = session.createQuery("select c from Car c").list();
        session.getTransaction().commit();
        session.close();
        return cars;
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Car car = session.find(Car.class, id);
        session.remove(car);
        System.out.println("ochtu");
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void creatTable() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.createNativeQuery("create table if not exists cars (id bigserial not null, mark varchar(255) not null, " +
                "producedCountry varchar(255), garage_id bigint, person_id bigint, primary key (id))");
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Car updateCar(Long id, Car car) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Car car1 = session.find(Car.class, id);
        car1.setMark(car.getMark());
        car1.setProducedCountry(car.getProducedCountry());
        session.merge(car1);
        session.getTransaction().commit();
        session.close();
        return car1;
    }
}
