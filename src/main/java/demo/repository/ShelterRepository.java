package demo.repository;

import demo.domain.Shelter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
@RestResource(path="shelters", rel="shelter")
public interface ShelterRepository extends CrudRepository<Shelter, Long> {
    public abstract List<Shelter> findAll();

    public abstract Shelter findByName(String name);
}
