package com.example.marq.Service;


import com.example.marq.Entities.Person;
import com.example.marq.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public Person update(Long id, Person person) {
        return repository.findById(id)
                .map(p -> {
                    p.setName(person.getName());
                    p.setLastname(person.getLastname());
                    return repository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Person no encontrada"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}