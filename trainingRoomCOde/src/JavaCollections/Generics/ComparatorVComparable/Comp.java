package JavaCollections.Generics.ComparatorVComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comp {

    public static void main(String[] args){

        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        Collections.sort(ducks);
        System.out.println(ducks);
        //System.out.println(new Duck("change").compareTo(new Robot("oliver")));;
        Animal a1 = new Animal();
        a1.id = 5;
        Animal a2 = new Animal();
        a2.id = 7;
        System.out.println(a1.compareTo(a2));
        System.out.println(a1.compareTo(a1));
        System.out.println(a2.compareTo(a1));

        /********************************************************************************************/
        //new Swan("Lucy",900);
        new Swan("Lucy",900); new Swan("Kyle", 1220);


    }
}
/*************************************************************************************************/
/**Comparable
 * Sorting using a single sequence, uses one element to sort entire list, e.g name
 * Affects the original class,
 * uses java.lang
 * */
class Duck implements Comparable<Duck> {
    private String name;

    public Duck(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
    public int compareTo(Duck d){
        return name.compareTo(d.name);
    }
}

class Robot{
    private String name;

    public Robot(String name){
        this.name = name;
    }
}

class Animal implements java.lang.Comparable<Animal>{
    public int id;

    public int compareTo(Animal a){
        return id - a.id;
    }
}

class LegacyDuck implements Comparable{
    private String name;
    public int compareTo(Object obj1){
        LegacyDuck d = (LegacyDuck) obj1; //Legacy code needs casting, no generics
        return name.compareTo(d.name);
    }
}
/*********************************************************************************************/
/**Comparator provides multiple sorting sequence, using multiple elements
 * Does not affect the original class unlike comparable
 * Uses compare method
 * found in java.util
 * */
class Swan implements Comparable<Swan>{
    private String name;
    private int weight;

    public Swan(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    public String getName(){ return this.name; }
    public String getNameQ(){return name;}
    public int getWeight(){ return this.weight; }
    public String toString(){return this.name + " ," + this.weight;}
    public int compareTo(Swan s){return name.compareTo(s.name);}
    Comparator<Swan> byWeight = new Comparator<Swan>() {
        @Override
        public int compare(Swan o1, Swan o2) {
            return o1.getWeight()-o2.getWeight();
        }
    };
    Comparator<Swan> byWeight1 = (o1, o2) -> {return o1.getWeight() - o2.getWeight();};
    Comparator<Swan> byWeight2 = (Swan o1, Swan o2) -> o1.getWeight() - o2.getWeight();
}
