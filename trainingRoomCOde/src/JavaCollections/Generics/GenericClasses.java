package JavaCollections.Generics;

public class GenericClasses {
    /**Generics are declared using a formal type parameter in angle brackets
     *Naming Conventions -:
     * E for an Element. K for a map key. V for a map value. N for a number.
     * T for a generic data type. S,U,V... for multiple generic types
     *Type Erasure - process of removing generics from a class
     * **/
    public static void main(String[] args){
       // Elephant eleanor = new Elephant(20, "Eleanor");
        Elephant eleanor = new Elephant();

        Crate<Elephant> elephantCrate = new Crate<>();
        elephantCrate.packCrate(eleanor);

        Elephant inNewHome =  elephantCrate.emptyCrate();

        Integer numPounds = 15_000;
        SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(eleanor, numPounds);

        String [] family = {"caleb", "phoenix", "lucien", "francis", "cox"};
        System.out.println("Computer please print out those names");
        for(String families : family){
            System.out.println(families);
        }
    }
}
