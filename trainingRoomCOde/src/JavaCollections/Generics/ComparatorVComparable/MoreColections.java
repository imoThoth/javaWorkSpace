package JavaCollections.Generics.ComparatorVComparable;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**Using Method References
 * Simplifying methods even more
 * */

class DuckHelper {
    private String name;
    private int weight;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }


    public static int compareByWeight(DuckHelper d1, DuckHelper d2) {
        return d1.getWeight() - d2.getWeight();
    }

    Comparator<DuckHelper> byName = new Comparator<DuckHelper>() {
        @Override
        public int compare(DuckHelper o1, DuckHelper o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    Comparator<DuckHelper> byName1 = (o1, o2) -> DuckHelper.compareByWeight(o1, o2);
    Comparator<DuckHelper> byName2 = DuckHelper::compareByWeight;//Target reference :Delimiter: Target method

    Consumer<List<Integer>> methodRef1 = Collections::sort; //Method Reference
    Supplier<ArrayList>methodRef2 = ArrayList::new; //Constructor Reference
}

public class MoreColections {
    public static void main(String[] args){

        { //Using the removeIf method
            List<String> list = new ArrayList<>();
            list.add("Magician");
            list.add("Warrior");
            list.add("Support");
            System.out.println(list);
            list.removeIf(s -> s.startsWith("M"));
            System.out.println("New list" + list);
        }

        {//Updating all elements
            List<Integer> list = Arrays.asList(1, 2, 3);
            list.replaceAll(x -> x*2);
            System.out.println(list);
        }

        { //Looping through a Collection
            List<String> cats = Arrays.asList("Cindy", "Chloe", "Fluffy", "DeTangle");

            //Way 1
            for(String cat : cats){
                System.out.println("Meow i am" + cat);
            }
            //Way 2
            cats.forEach(c -> System.out.println(c));

            //Way3
            cats.forEach(System.out::println);
        }

        { //Merging Through HashMaps

            //Takes 2 values of the same type, compare and return the one with the longest length
            BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

            Map<String, String> favourites = new HashMap<>();
            favourites.put("Tom", "Tram");
            favourites.put("Jenny", "Bus Tour");
            String jenny = favourites.merge("Tom", "Skyride", mapper); //Returns Tom Sky-ride
            String Tom = favourites.merge("Tom", "Skyride", mapper);// Returns Jenny Bus Tour
        }

        {//Compute if present
            Map<String, Integer> counts = new HashMap<>();
            counts.put("Jenny", 1);
            BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;
            Integer jenny = counts.computeIfPresent("Jenny", mapper); //returns 2
            Integer tom = counts.computeIfPresent("Tom", mapper); //returns null

        }

        {//Compute if Absent
            Map<String, Integer> counts = new HashMap<>();
            counts.put("Jenny", 1);
            Function<String, Integer> mapper = (k) -> 1;
            Integer jenny = counts.computeIfAbsent("Jenny", mapper); //returns 0
            Integer tom = counts.computeIfAbsent("Tom", mapper); //returns 1
        }
    }
}
