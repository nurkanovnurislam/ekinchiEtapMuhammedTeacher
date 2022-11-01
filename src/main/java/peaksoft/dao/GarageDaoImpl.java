package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.Config;
import peaksoft.entity.Car;
import peaksoft.entity.Garage;

import java.util.List;

public class GarageDaoImpl implements GarageDao {
    SessionFactory sessionFactory = Config.getSessionFactory();

    @Override
    public void saveGarage(Garage garage) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(garage);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Garage getGarageById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Garage garage = session.find(Garage.class, id);
        session.getTransaction().commit();
        session.close();
        return garage;
    }

    @Override
    public List<Garage> getAllGarage() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<Garage> list = session.createQuery("select c from  Garage c").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Garage garage = session.find(Garage.class, id);
        session.remove(garage);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void creatTable() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.createNativeQuery("create table garages (id bigserial not null, isEmpty boolean not null, name varchar(255), car_id bigint, primary key (id))");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Car updateGarage(Long id, Garage garage) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Garage garage1 = session.find(Garage.class, id);
        garage1.setName(garage.getName());
        garage1.setEmpty(garage.isEmpty());
        session.merge(garage1);
        session.getTransaction().commit();
        session.close();
        return null;
    }
}
