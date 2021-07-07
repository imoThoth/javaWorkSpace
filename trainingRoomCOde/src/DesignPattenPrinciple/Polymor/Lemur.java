package DesignPattenPrinciple.Polymor;

class Primate{
    public boolean hasHair(){
        return true;
    }
}

interface HasTail{
    public boolean isTailStriped();
}

public class Lemur extends Primate implements HasTail {
    public int age = 10;
    public boolean isTailStriped(){
        return false;
    }

    public static void main(String[] args){
        /*Polymorphism
        *Object type determines which properties exist within object memory
        * Object reference determines which method and variables are accessible in java programmes
        **/
        Lemur lemur = new Lemur();//lemur has all object properties and its own
        Object lemurAsObject = lemur;

        System.out.println("Lemurs Age: " + lemur.age); //10

        HasTail hasTail = lemur;
        System.out.println("is Tail Striped: " + hasTail.isTailStriped()); //false
        System.out.println("Do Lemurs have tails: " + lemur.isTailStriped()); //false

        Primate primate = lemur;
        System.out.println("Do Primates have hair: " + primate.hasHair());
/*************************************************************************************/
//Casting Object References
        Primate primate1 = lemur; //super class to subclass
        Lemur lemur2 = (Lemur) primate; //subc

        //Rules of casting
        //Casting obj from subclass to superclass does not require explicit cast
        //Casting from superclass to subclass requires an explicit cast
        //Cannot cast to unrelated types
    }
}
