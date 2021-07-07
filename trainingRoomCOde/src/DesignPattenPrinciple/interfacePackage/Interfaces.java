package DesignPattenPrinciple.interfacePackage;

interface Fly{
    int getWingSpan() throws Exception;
    int MAX_SPEED = 100;

    default void land(){
        System.out.println("Animal is landing");
    }
    //availaible to implementing class even without an instance of the interface
    static double calculateSpeed(float distance, double time){
        return distance/time;
    }
}
class Eagle implements Fly{ //implement used when implementing interface

    public int getWingSpan(){
        return 15;
    }
    public void land(){
        System.out.println("Eagle is diving fast");
    }
}

public class Interfaces {
    //Interface = abstract data types, similar to public abstract method that any class implementing the interface must provide
    //Interfaces fields are constantly public static variables, and may include default and static methods
    //Compiler adds public to all interface methods and abstract to all non static and non default methods
}
