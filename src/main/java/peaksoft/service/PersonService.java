package peaksoft.service;

import peaksoft.entity.Person;

import java.util.List;

public interface PersonService {
    void savePerson(Person person);

    Person getPersonById(Long id);

    Person getAllPeople();

    void removeById(Long id);

    void creatTable();

    Person updatePerson(Long id,Person person);
}
