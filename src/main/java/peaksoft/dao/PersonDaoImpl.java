package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.Config;
import peaksoft.entity.Person;

import java.util.List;

public class PersonDaoImpl implements PersonDao{
    SessionFactory sessionFactory = Config.getSessionFactory();

    @Override
    public void savePerson(Person person) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Person getPersonById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Person person = session.find(Person.class, id);
        session.getTransaction().commit();
        session.close();
        return person;
    }

    @Override
    public List<Person> getAllPeople() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<Person> list = session.createQuery("select p from Person  p").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void removeById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Person person = session.find(Person.class, id);
        session.remove(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void creatTable() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.createNativeQuery("create table people (id bigserial not null, age integer not null, email varchar(255), gender varchar(255) not null, name varchar(255), company_id bigint, primary key (id))");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Person person1 = session.find(Person.class, id);
        person1.setName(person.getName());
        person1.setAge(person.getAge());
        person1.setEmail(person.getEmail());
        person1.setGender(person.getGender());
        session.merge(person1);
        session.getTransaction().commit();
        session.close();
        return null;
    }
}
