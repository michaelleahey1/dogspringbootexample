package com.ust.dogspringbootex.dao;

import com.ust.dogspringbootex.model.Dog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DogDao {
    int insertDog(UUID id, Dog dog);
    default int insertDog(Dog dog){
        UUID id = UUID.randomUUID();
        return insertDog(id, dog);
    }
    List<Dog> selectAllDogs();
    Optional<Dog> selectDogId(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Dog dog);
}
