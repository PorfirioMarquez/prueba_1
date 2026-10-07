package com.example.marq.Controller;

import com.example.marq.Entities.Person;
import com.example.marq.Service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/person")
    public class PersonController {

        private final PersonService service;

        public PersonController(PersonService service) {
            this.service = service;
        }

        @GetMapping
        public List<Person> findAll() {
            return service.findAll();
        }

        @GetMapping("/{id}")
        public Person findById(@PathVariable Long id) {
            return service.findById(id)
                    .orElseThrow(() -> new RuntimeException("Person no encontrada"));
        }

        @PostMapping
        public Person save(@RequestBody Person person) {
            return service.save(person);
        }

        @PutMapping("/{id}")
        public Person update(
                @PathVariable Long id,
                @RequestBody Person person) {
            return service.update(id, person);
        }

        @DeleteMapping("/{id}")
        public String delete(@PathVariable Long id) {
            service.delete(id);
            return "Person eliminada correctamente";
        }
    }