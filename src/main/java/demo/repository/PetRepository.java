package demo.repository;

import demo.domain.Pet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
@RestResource(path="pets", rel="pets")
public interface PetRepository extends CrudRepository<Pet, Long> {
    public abstract List<Pet> findAll();

    public abstract Pet findByName(String name);
}
