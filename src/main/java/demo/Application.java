package demo;

import demo.domain.Pet;
import demo.domain.Shelter;
import demo.repository.PetRepository;
import demo.repository.ShelterRepository;
import demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static demo.PetTypeEnum.CAT;

@SpringBootApplication
public class Application {

	@Autowired TeamRepository teamRepository;

	@Autowired PetRepository petRepository;

	@Autowired ShelterRepository shelterRepository;

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @PostConstruct
	public void init() {

		List<Pet> pets = new ArrayList<>();
		Pet cat = new Pet(CAT);
		System.out.println("Name is currently " + cat.getName());
		cat.setName("Garfield");
		System.out.println("Name has been changed to " + cat.getName());
		pets.add(cat);

		//New code to demonstrate the additional functionality.
		System.out.println("----------------------------------------------");
		Pet cat2 = new Pet("Kelly", CAT);
		System.out.println("Name is currently " + cat2.getName());
		cat2.setName("Mary");
		System.out.println("Name has been changed to " + cat2.getName());
		cat2.setName("Katy Purry");
		System.out.println("Name has been changed to " + cat2.getName());
		System.out.println("Former names are: " + cat2.getFormerNames());
		System.out.println("Average name length is: " + cat2.getAverageNameLength());
		System.out.println("Cat's original age is: " + cat2.getAge());

		for (int i = 1; i <= 10; i++)
		{
			cat2.speak();
			System.out.println("Number of times cat has spoken: " + i);
			System.out.println("Cat's current age is: " + cat2.getAge());
		}
		pets.add(cat2);

		petRepository.saveAll(pets);

		//Create shelters
		List<Shelter> shelters = new ArrayList<>();

		Shelter shelter = new Shelter();
		shelter.setName("APF");
		shelters.add(shelter);

		shelter = new Shelter("ASPCA");
		shelters.add(shelter);

		//println("shelters: ${shelters}")

		shelterRepository.saveAll(shelters);
	}    
    
}
