package Lesson1;

//inheritance = is a relationship
//car is a vehicle
public class Car extends Vehicle {
    private int doors;
    private int engineCapacity;

    public  Car (String name, int doors, int engineCapacity){
        super(name);
        this.doors = doors;
        this.engineCapacity = engineCapacity;
    }
}
