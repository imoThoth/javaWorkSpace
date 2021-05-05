import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Airport lhr = new Airport("LHR");
        Airport jfk = new Airport("JFK");

        System.out.println(jfk.getAirports().size());
    }
}

class Airport{
    private static List<Airport> allAirports = new ArrayList<>();

    private String name;

    public Airport(String name) {
        this.name = name;
        this.allAirports.add(this);
    }

    public List<Airport> getAirports() {
        return allAirports;
    }

}