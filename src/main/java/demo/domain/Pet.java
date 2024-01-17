package demo.domain;

import demo.PetTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Pet {
    public Pet() {
        super();
    }
    public Pet(PetTypeEnum petType) {
        this.petType = petType;
    }

    public Pet(String name, PetTypeEnum petType) {
        this.name = name;
        this.petType = petType;
    }

    /**
     * Set Pet name attribute.
     *
     * @param newName Pet's new name
     */
    public void setName(String newName) {
        if (name != null) {
            //Add current Pet name to former names ArrayList
            formerNames.add(name);
        }

        //Update Pet name to new name.
        name = newName;
    }

    /**
     * Makes the Pet say "Feed Me!" by printing to word to STDOUT
     */
    public void speak() {
        if (petType.getId().equals("Cat")) {
            System.out.println("Meow");
        } else if (petType.getId().equals("Dog")) {
            System.out.println("Woof");
        } else {
            System.out.println("Feed Me!");
        }

        //Call helper method
        speakCountAgeCalculation();
    }

    /**
     * Overload the speak method to allow caller to
     * determine what the Pet is going to say.
     * Again, print word to STDOUT
     *
     * @param words The Pet's official statement.
     */
    public void speak(String words) {
        System.out.println(words);
        //Call helper method
        speakCountAgeCalculation();
    }

    private void speakCountAgeCalculation() {
        speakCount++;
        if (speakCount % 5 == 0) {
            age++;
        }

    }

    /**
     * Return the average length of all the names the Pet has ever had.
     *
     * @return average name length
     */
    public double getAverageNameLength() {
        int total = name.length();
        for (String name : formerNames) {
            total += name.length();
        }


        return (double) total / (formerNames.size() + 1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getFormerNames() {
        return formerNames;
    }

    public void setFormerNames(ArrayList<String> formerNames) {
        this.formerNames = formerNames;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public int getSpeakCount() {
        return speakCount;
    }

    public void setSpeakCount(int speakCount) {
        this.speakCount = speakCount;
    }

    public PetTypeEnum getPetType() {
        return petType;
    }

    public void setPetType(PetTypeEnum petType) {
        this.petType = petType;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private ArrayList<String> formerNames = new ArrayList<String>();
    private Integer age = (int) Math.floor(Math.random() * 6 + 5);
    private String favoriteFood;
    private int speakCount;
    private PetTypeEnum petType;
}
