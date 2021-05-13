package com.axel.doggraphqlapi.repository;

import com.axel.doggraphqlapi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    /*@Query("insert into Dog dog(dog.name, dog.breed, dog.origin) values(name, breed, origin)")
    int createNewDog(String name, String breed, String origin);

    @Query("select dog.id, dog.breed from Dog dog")
    List<String> findDogBreeds();

    @Query("select dog.id, dog.breed from Dog dog where dog.id = :id")
    String findDogBreedById(Long id);

    @Query("delete dog.id, dog.breed from Dog dog")
    Boolean deleteDogBreed(String breed);

    @Query("select dog.id, dog.name from Dog dog")
    List<String> findAllDogNames();

    @Query("update dog.id, dog.name from Dog dog")
    Dog updateDogName(String name, Long id);*/

}
