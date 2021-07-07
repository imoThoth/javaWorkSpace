package DesignPattenPrinciple.SingletonPattern;

/*
* Creates Object whose type is not known until run-time
* -Produces instances of objects based on set of input parameters
* -Supports class polymorphism
*
* -Factory patterns are mostly created using static method which return objects
* - They do not require a pointer to an instance of the factory class
* */

abstract class Food{
    private int quantity;
    public Food(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity(){
        return quantity;
    }
    public abstract void consumed();
}

class Hay extends Food{
    public Hay(int quantity){
        super(quantity);
    }
    public void consumed(){
        System.out.println("Hay eaten: " + getQuantity());
    }
}

class Pellets extends Food{
    public Pellets(int quantity){
        super(quantity);
    }
    public void consumed(){
        System.out.println("Pellets eaten: " +getQuantity());
    }
}

class Fish extends Food{
    public Fish(int quantity){
        super(quantity);
        }
    public void consumed(){
        System.out.println("Fish eaten: " + getQuantity()); }
        }

//Creates factory pattern that returns food type based on set of inputs
class FoodFactory{
    public static Food getFOod(String animalName){
        switch (animalName){
            case "zebra" : return new Hay(100);
            case "rabbit" : return new Pellets(60);
            case "goat" : return new Pellets(69);
            case "polar bear" : return new Fish(2);
        }
        //Good practice to throw exception if no matching parameter found
        throw new UnsupportedOperationException("Could not find animal: " + animalName);
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        final Food food = FoodFactory.getFOod("polar bear");
        food.consumed();
    }
}
