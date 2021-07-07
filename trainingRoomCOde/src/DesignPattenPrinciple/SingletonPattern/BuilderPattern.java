package DesignPattenPrinciple.SingletonPattern;

/* Creates object which allows numerous values to be set at the time of instantiation
*-Needed when a class size is growing substantially
*-Problem of a constructor growing to large is called anti-pattern
*
*Builder pattern allows parameter to be passed as builder objects
* This is achieved through method-chainin, with object generated with final build call
* Analogous to taking a mutable object and making it read-only
* */

import java.util.Arrays;
import java.util.List;

//Creates a mutable class
class AnimalBuilder{
    private String species;
    private int age;
    private List<String> favouiteFoods;

    public AnimalBuilder setAge(int age){
        this.age = age;
        return this;
    }
    public AnimalBuilder setSpecies(String species){
        this.species = species;
        return this;
    }
    public AnimalBuilder setFavouriteFoods(List<String> favouriteFoods){
        this.favouiteFoods = favouriteFoods;
        return this;
    }
    public ImmutableAnimal build(){
        return new ImmutableAnimal(species, age, favouiteFoods);
    }
}


public class BuilderPattern {

    public static void main(String[] args) {
        AnimalBuilder duckBuilder = new AnimalBuilder();
        duckBuilder
                .setAge(5)
                .setFavouriteFoods(Arrays.asList("grass", "fish"))
                .setSpecies("duck");

        ImmutableAnimal duck = duckBuilder.build();

        ImmutableAnimal flamingo = new AnimalBuilder()
                .setAge(20)
                .setFavouriteFoods(Arrays.asList("algae","insects"))
                .setSpecies("flamingo").build();
    }
}
