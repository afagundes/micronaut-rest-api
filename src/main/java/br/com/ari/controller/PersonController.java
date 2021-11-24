package br.com.ari.controller;

import br.com.ari.dto.Message;
import br.com.ari.model.Person;
import br.com.ari.service.PersonService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import javax.validation.Valid;

@Validated
@Controller("/persons")
public class PersonController {

    private final PersonService personService;

    @Inject // Opcional
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Get
    public HttpResponse<?> getPersons() {
        return HttpResponse.status(HttpStatus.OK).body(this.personService.findAll());
    }

    @Post
    public HttpResponse<?> savePerson(@Body @Valid Person person) {
        this.personService.save(person);
        return HttpResponse.status(HttpStatus.CREATED).body(new Message(HttpStatus.CREATED.getCode(), "Person successfully created!"));
    }

}
