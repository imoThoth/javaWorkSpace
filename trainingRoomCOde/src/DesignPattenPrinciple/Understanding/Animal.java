package DesignPattenPrinciple.Understanding;
//Design principles = best coding practices
/*
 * Encapsulation - Allows class to maintain invariants about internal data
 * Invariant - Property/Truth that is maintained after data is modified
 *
 *
 *
 * */
public class Animal {
    private String species;
    private int age;

    public Animal(String species){
        this.setSpecies(species);
    }
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String species){
        if(species == null || species.trim().length()==0){
            throw new IllegalArgumentException("Species is required");
        }
        this.species = species;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age<0){
            throw new IllegalArgumentException("Age cannot be a negative number");
        }
        this.age = age;
    }
}
