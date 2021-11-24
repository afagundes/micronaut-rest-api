package br.com.ari.service;

import br.com.ari.model.Person;

public interface PersonService {

    Iterable<Person> findAll();

    Person save(Person person);

}
