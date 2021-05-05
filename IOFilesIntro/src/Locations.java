import sun.reflect.annotation.TypeAnnotation;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        //if exception is thrown when closing the stream in addition to an error in try block,
        // causes exception to be supressed,
        // exception from try block thrown up the stack
        try(FileWriter locfile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter(("directions.txt"))){
            for (Location location : locations.values()){
                locfile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction : location.getExits().keySet()){
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }
//        FileWriter locafile = null;
//        try{
//            locafile = new FileWriter("locations.txt");
//            for(Location location : locations.values()){
//                locafile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                throw new IOException("test exception while writing");
//            }
//        }finally{
//            System.out.println("In finally block");
//                if(locafile != null) {
//                    locafile.close();
//                    System.out.println("Attempting to close locafile");
//                }
//        }
//
   }

    static {
        //uses file reader to pass name of file as a constructor
        //gets data from passed file
        //filereader readable is passed to the constructor of a scanner
        //causing scanner to work with data in readable
        //rather than nextInt() which reads user input
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("locations_big.txt"));
            scanner.useDelimiter(","); //separates each description with a coma
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter()); //skips over using a coma
                String description = scanner.nextLine();
                System.out.println("Imported loc " + loc + ":" + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        //now read the exits
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt(dest);
                  String input = scanner.nextLine();
                  String[] data = input.split(",");
                  int loc = Integer.parseInt(data[0]);
                  String direction = data[1];
                  int destination = Integer.parseInt(data[2]);

                System.out.println(loc + ":" + direction + ":" + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }







//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest",tempExit));

    }

    @Override
    public int size() {
        //returns how many elements in hashmap
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}

