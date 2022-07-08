package com.ust.dogspringbootex.service;

import com.ust.dogspringbootex.dao.DogDao;
import com.ust.dogspringbootex.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DogService {
    private final DogDao dogDao;

    @Autowired
    public DogService(@Qualifier("fakeDao") DogDao dogDao) {
        this.dogDao = dogDao;
    }

    public int addDog(Dog dog) {
        return dogDao.insertDog(dog);
    }

    public List<Dog> selectAllDogs() {
        return dogDao.selectAllDogs();
    }

    public Optional<Dog> getDogId(UUID id) {
        return dogDao.selectDogById(id);
    }

    public int deleteDog(UUID id) {
        return dogDao.deleteDogById(id);
    }

    public int updateDog(UUID id, Dog dog) {
        return dogDao.updateDogById(id, dog);
    }
}