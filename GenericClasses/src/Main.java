import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FootballPlayer joe = new FootballPlayer("Joe");
        SoccerPlayer pat = new SoccerPlayer("Pat");
        FootballPlayer david = new FootballPlayer("David");
        FootballPlayer gigs = new FootballPlayer("Gigs");
        FootballPlayer young = new FootballPlayer("Young");
        FootballPlayer old = new FootballPlayer("Old");

        TeamClass<FootballPlayer> demManDere = new TeamClass<>("demManDere");
        demManDere.addPlayer(joe);
        demManDere.addPlayer(david);
        demManDere.addPlayer(gigs);
        demManDere.addPlayer(young);

        TeamClass<FootballPlayer> melbourne = new TeamClass<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordone");
        melbourne.addPlayer(banks);

        TeamClass<FootballPlayer> hawthorn = new TeamClass<>("Hawthorn");
        TeamClass<FootballPlayer> cawthorne = new TeamClass<>("Cawthorne");

        hawthorn.matchResults(cawthorne,2,0);
        hawthorn.matchResults(demManDere,1, 9);

        demManDere.matchResults(cawthorne, 3, 1);

        System.out.println("Rankings");
        System.out.println(cawthorne.getName() + " " +cawthorne.ranking());
        System.out.println(demManDere.getName() + " " +demManDere.ranking());
        System.out.println(hawthorn.getName() + " " +hawthorn.ranking());

        System.out.println(cawthorne.compareTo(hawthorn));
        System.out.println(cawthorne.compareTo(demManDere));

        System.out.println(demManDere.compareTo(hawthorn));
        System.out.println(demManDere.compareTo(cawthorne));

        System.out.println(hawthorn.compareTo(cawthorne));
        System.out.println(hawthorn.compareTo(demManDere));

        ArrayList<TeamClass>teams = new ArrayList<>();
        teams.add(cawthorne);
        teams.add(hawthorn);
        teams.add(demManDere);
//        System.out.println(Collections.sort(teams));;
    }
}
