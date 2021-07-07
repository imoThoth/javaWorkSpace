package JavaCollections.Generics.ListSetMapsQueyes;

import java.util.*;

public class partOne {
    /**
     * List: Ordered collection of elements allowing duplicate entries
     *      Elements within list are able to be accessed with int index.
     *LinkedList implements both a list and a queue, but random index takes linear time
     * Set: Collection which does not allow duplicate entries.
     * HashSet - stores element in hash tables and uses hashCode but lose order
     * TreeSet - stores element in tree-structure, sets are always ordered uses OlogN
     * Queue: Collection that orders elements in specific order for processing
     *      FIFO order but other orderings are possible
     * Map: Collection mapping keys to values, no duplicate keys allowed.
     *      Elements are ordered using a key-pair value
     *     
     */

    public static void main(String[] args){

        {   //Creating Hash Set
            Set<Integer> set = new HashSet<>();
            boolean b1 = set.add(50);
            boolean b2 = set.add(89);
            boolean b3 = set.add(50);

            for (Integer integer : set) {
                System.out.println("Hash Set Number " + integer);
            }
        }

        { //Creating Tree Set which implements NavigableSet
            Set<Integer> set = new TreeSet<>();
            boolean b1 = set.add(49);
            boolean b2 = set.add(29);
            boolean b3 = set.add(49);

            for(Integer integer: set){
                System.out.println("Tree Set Number " + integer);
            }
        }

        {//Creating and Iterating through Hash-Maps
            Map<String, String> map = new HashMap<>();
            map.put("koala", "bamboo");
            map.put("lion", "meat");
            map.put("giraffes", "leaves");
            String food = map.get("koala");
            for(String v: map.keySet()){
                System.out.println("Key " + v);
                //values come out in different order in,new,Treemaps

            }
        }
        /**Arrays and When to use them
         *
         * Top zoo map from stack of map = ArrayDeque
         * Sell tickets in order of position in line = LinkedList = First in First out
         * Write and Tell list of fave elephants = ArrayList
         * List unique animals to see as zoo = HashSet
         * List unique animals in alhabetical order = TreeSet
         * Find animals based on key and value = HashMap
         * */
    }
}
