package demo.controller;

import demo.domain.Pet;
import demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
    @GetMapping("/pets")
    public Iterable<Pet> getPets() {
        try {
            return petRepository.findAll();
        } catch (Exception e) {
            return null;
        }


    }

    @GetMapping("/pet/{id}")
    public Pet getPetByID(@PathVariable Object id) {
        try {
            return ((Pet) (petRepository.findById((Long) id).get()));
        } catch (Exception e) {
            return null;
        }


    }

    @Autowired
    private PetRepository petRepository;
}
