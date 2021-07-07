package DesignPattenPrinciple.FuncInterface;


class Animal{}

@FunctionalInterface //Any interface which contains exactly one abstract method
interface Sprint{
    public void sprint(Animal animal);
}

class Tiger implements Sprint{
    public void sprint(Animal animal){
        System.out.println("Animal is sprinting fast! " + animal);
    }
}

public class DefFuncInterface {
}
