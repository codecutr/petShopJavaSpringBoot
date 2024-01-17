package demo.controller;

import demo.domain.Shelter;
import demo.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShelterController {
    @GetMapping("/shelters")
    public Iterable<Shelter> getShelters() {
        return shelterRepository.findAll();

    }

    @GetMapping("/shelter/{name}")
    public Shelter getShelterByName(@PathVariable String name) {
        return shelterRepository.findByName(name);
    }

    @GetMapping("/shelter/{id}")
    public Shelter getShelterById(@PathVariable Long id) {
        return shelterRepository.findById(id).get();
    }

    public ShelterRepository getShelterRepository() {
        return shelterRepository;
    }

    public void setShelterRepository(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    @Autowired
    private ShelterRepository shelterRepository;
}
