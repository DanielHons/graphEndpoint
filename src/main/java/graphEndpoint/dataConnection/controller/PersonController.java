package graphEndpoint.dataConnection.controller;

import graphEndpoint.dataConnection.domain.Person;
import graphEndpoint.dataConnection.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Daniel Hons on 28.04.2017.
 *
 * Controller to provide Rest functionality for persons
 */
@RestController
@RequestMapping("api/person")
public class PersonController {

    @Autowired private PersonRepository personRepository;

    @RequestMapping("/list")
    public Iterable<Person> getAll()
    {
        return personRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        personRepository.delete(id);
        return "OK";
    }

    @PostMapping
    public Person create(@RequestBody Person person)
    {
        return personRepository.save(person);
    }
}
