import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36", "N24",
                "B10", "B21" , "B30",
                "G8", "G19", "G29", "g49",
                "T7", "T15", "T22",
                "F1", "F16", "F27"
        );

        List<String> moreBingoNumbers = Arrays.asList(
                "A40", "A36", "A24", "a4",
                "D10", "D21" , "D30", "d3",
                "E8", "E19", "E29", "e49",
                "H7", "H15", "H22", "h37",
                "I1", "I16", "I27", "i31"
        );

        List<String> gNumbers = new ArrayList<>();

        someBingoNumbers.forEach( bingoNumber -> {
            if(bingoNumber.toUpperCase().startsWith("G")){
                gNumbers.add(bingoNumber);
                System.out.println(bingoNumber);
            }
        });

//        sort numbers added from someBingoNumber lambda expression
        gNumbers.sort( (String s1, String s2) -> s1.compareTo(s2));
//        printed sorted numbers
        gNumbers.forEach( (String s) -> System.out.println(s));

        moreBingoNumbers
                .stream() // creates a copy of the moreBingoNumbers list
                .map(String::toUpperCase) // uses a util function method reference... can also use s -> s.toUpperCase
                .filter( s -> s.startsWith("E"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N37", "I30", "O24", "O60", "N11");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println(concatStream.distinct().count()); // gets total distinct value in stream
        System.out.println(concatStream.count()); // gets total values in stream
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count()); // gets total distinct value in stream and lists each value out


    }
}
