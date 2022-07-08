package com.ust.dogspringbootex.api;

import com.ust.dogspringbootex.model.Dog;
import com.ust.dogspringbootex.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value="api/vi/dog")
public class DogController {
    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }
    @GetMapping
    public List<Dog> getAllPeople(){
        return dogService.selectAllDogs();
    }
    @GetMapping( value = "/{id}" )
    public int getDog(@PathVariable("id") UUID id){
    return dogService.deleteDog(id);
    }
    @PutMapping(value = "/{id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int updatePerson(@PathVariable("id")UUID id, @RequestBody Dog dog){
        return dogService.updateDog(id, dog);
    }
}

