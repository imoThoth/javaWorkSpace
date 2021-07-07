package DesignPattenPrinciple.SingletonPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Immutable Objects
* -Creating an object whose state does not change after creation
* -Created without the use of setters
* -Often used with encapsulation
* -state do not change, making them thread safe
*/
/* Rules for Creating Immutable Classes
* -Use constructor to set all properties of objects
* - Instance variable marked with final or private
* -No setters defined
* -References of the class, may not be modified or accessed directly
* -Methods cannot be overridden
* */
final class Animal{
   private final List<String> favoriteFoods;

   public Animal(List<String> favoriteFoods){
       if(favoriteFoods == null){
           throw new RuntimeException("Favoruite Food Is Required");
       }
       this.favoriteFoods = new ArrayList<String>(favoriteFoods);
   }
   //User may get list of favourite food, but they can clear list by calling clear method after
    //Breaks rule 4
   public List<String> getFavoriteFoods(){ //Makes class mutable
       return favoriteFoods;
   }
}

final class ImmutableAnimal{
    private final String species;
    private final int age;
    private final List<String> favouriteFoods;

    public ImmutableAnimal(String species, int age, List<String> favouriteFoods){
        this.species = species;
        this.age = age;
        if(favouriteFoods == null){
            throw new RuntimeException("Favourite food is required");
        }
        this.favouriteFoods = new ArrayList<String>(favouriteFoods); //has no access to private list
        //this.favouriteFoods = favouriteFoods - has access to private list, making it mutable
    }
    public String getSpecies(){
        return this.species;
    }
    public int getAge(){
        return this.age;
    }
    public int getFavouriteFoodsCount(){
        return this.favouriteFoods.size();
    }
    public String getFavouriteFood(int x){
        return this.favouriteFoods.get(x);
    }
}

public class ImmutableObj{
    public static void main(String[] args){
        //Modifying the Immutable

        String firstName = "Grace";
        String fullName = firstName + "Hopper";

        //Create instance of a new Animals
        ImmutableAnimal lion = new ImmutableAnimal("lion", 5, Arrays.asList("meat, more meat"));

        //Create new Animal instance using data from first instance
        List<String> favouriteFoods = new ArrayList<String>();
        for(int i=0; i<lion.getFavouriteFoodsCount(); i++){
            favouriteFoods.add(lion.getFavouriteFood(i));
        }
        //Copies the age of the first instance of lion and adds one
        ImmutableAnimal updatedLion = new ImmutableAnimal("Lion", lion.getAge() +1, favouriteFoods);
    }
}



