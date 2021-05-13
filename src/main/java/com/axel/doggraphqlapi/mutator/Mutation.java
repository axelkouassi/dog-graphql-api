package com.axel.doggraphqlapi.mutator;

import com.axel.doggraphqlapi.entity.Dog;
import com.axel.doggraphqlapi.repository.DogRepository;
import com.axel.doggraphqlapi.exception.BreedNotFoundException;
import com.axel.doggraphqlapi.exception.DogNotFoundException;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        // Loop through all dogs to check their breed
        for (Dog d:allDogs) {
            if (d.getBreed().equals(breed)) {
                // Delete if the breed is found
                dogRepository.delete(d);
                deleted = true;
            }
        }
        // Throw an exception if the breed doesn't exist
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found!", breed);
        }
        return deleted;
    }

    public Dog updateDogName(String newName, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            // Set the new name and save the updated dog
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        }else{
            throw new DogNotFoundException("Dog Not Found!", id);
        }
    }

    /*public Dog newDog(String name, String breed){
        Dog dog = new Dog(name, breed);
        dogRepository.save(dog);
        return dog;
    }

    public boolean deleteDog(Long id){
        dogRepository.deleteById(id);
        return true;
    }*/


}
