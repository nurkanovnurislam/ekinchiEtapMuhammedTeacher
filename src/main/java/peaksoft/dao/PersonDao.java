package peaksoft.dao;

import peaksoft.entity.Person;

import java.util.List;

public interface PersonDao {
    void savePerson(Person person);

    Person getPersonById(Long id);

   List<Person> getAllPeople();

    void removeById(Long id);

    void creatTable();

    Person updatePerson(Long id,Person person);
}
