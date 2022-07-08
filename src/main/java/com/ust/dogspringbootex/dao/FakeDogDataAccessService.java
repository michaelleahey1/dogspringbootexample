package com.ust.dogspringbootex.dao;

import com.ust.dogspringbootex.model.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDio")
public class FakeDogDataAccessService implements DogDao{
    private static List<Dog> DB = new ArrayList<>();

    @Override
    public int insertDog(UUID id, Dog dog){
        DB.add(new Dog(id, dog.getName()));
        return 1;
    }
    @Override
    public List<Dog> selectAllDogs(){
        return DB;
    }
    @Override
    public int deleteDogById(UUID id) {
        Optional<Dog> dogMaybe = SelectDogById(id);
        if (dogMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(DogMaybe.get());
        return 1;
    }
    @Override
    public int updateDogById(UUID id, Dog updateDog) {
        return selectDogById(id).map(originalDog -> {
            int updateIndex = DB.indexOf(originalDog);
            if (updateIndex > 0) {
                DB.set(updateIndax, updateDog);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
    @Override
    public Optional<Dog> selectDogById(UUID id){
        return DB.stream().filter(dog -> dog.getId().equals(id).findFirst());
    }
}
