package DesignPattenPrinciple.FuncInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.sun.deploy.uitoolkit.impl.awt.AWTClientPrintHelper.print;

public class Animals{
    private String species;
    private boolean canHop;
    private boolean canSwim;
    public Animals(String speciesName, boolean hopper, boolean swimmer){
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }
    public boolean canHop(){ return canHop;}
    public boolean canSwim(){return canSwim;}
    public String toString(){return species;}
}

interface CheckTrait{
    public boolean test(Animal a);
}

//lambda to check if sample animals match specified criteria
class FindMatchingAnimals{
    private static void print(Animal animal, CheckTrait trait){
        if (trait.test((animal)))
                System.out.println(animal);
    }
}

interface checkTrait{
    public boolean test(Animal a);
}

class FunInterfaceLambda {
    public static void main(String[] args){
        System.out.println();
       // print(new Animals("fish",false,true));
       // print(new Animals("fish", false, true), a -> a.canHop());
        //print(new Animals("kangaroo", true, false), a -> a.canHop());
      //  System.out.println(new Animals("fish",false,true), a -> a.));
      //Animals a =  new Animals("kangaroo", true, false);
      //System.out.println(a.canHop());
      ArrayList<Animals> funAnimals = new ArrayList<>();
      funAnimals.add(new Animals("fish", false, true));
      funAnimals.add(new Animals("python", false, true));
      funAnimals.add(new Animals("frog", true, true));
      funAnimals.add(new Animals("kangaroo", true, false));

      Consumer<Animals> isHoppingAnimal = a -> System.out.println(String.format("%s %s hop",a.toString(), a.canHop() ? "can" : "cannot" ));

      Consumer<Animals> isSwimmingAnimal = s -> System.out.println(String.format("%s can%s swim", s.toString(), s.canSwim() ? "" : "not"));

      funAnimals.forEach(isHoppingAnimal);
      System.out.println("swimming animals");
      funAnimals.forEach(isSwimmingAnimal);
    }
    }

