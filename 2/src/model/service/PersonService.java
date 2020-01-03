package model.service;

import model.entity.Person;
import model.repository.PersonDA;

import java.util.List;

public class PersonService {
    public static void save(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.insert(person);
        personDA.close();
    }

    public static void update(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.update(person);
        personDA.close();
    }

    public static List<Person> findAll() throws Exception {
        PersonDA personDA = new PersonDA();
        List<Person> personList = personDA.select();
        personDA.close();
        return personList;


    }
    public static void delete(Person person)throws Exception
    {
        PersonDA personDA = new PersonDA();
        personDA.delete(person);
        personDA.close();
    }

    public static void main(String[] args) throws Exception {
      Person person = new Person();
      person.setId(777);
      delete(person);
    }
}
