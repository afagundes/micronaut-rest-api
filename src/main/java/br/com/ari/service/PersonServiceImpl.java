package br.com.ari.service;

import br.com.ari.model.Person;
import br.com.ari.repository.PersonRepository;
import jakarta.inject.Singleton;

@Singleton
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

}
