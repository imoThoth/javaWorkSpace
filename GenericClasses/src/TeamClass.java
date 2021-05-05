import java.util.ArrayList;

public class TeamClass<T extends Player> implements Comparable<TeamClass<T>> { //T indicates Team will receive a type
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public TeamClass(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
           // System.out.println(((Player)player).getName() + " is already on team");
            System.out.println(player.getName() + " is already on team");

        } else{
            members.add(player);
            // System.out.println(((Player)player).getName() + " is already on team");
            System.out.println(player.getName() + " picked for " + this.name);
        }
        return true;
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResults(TeamClass<T> opponent, int ourScore, int oppScore){
        String message;

        if(ourScore > oppScore){
            won++;
            message = " beat ";
        } else if(ourScore == oppScore){
            tied++;
            message = " drew with ";
        }else{
            message = " lost ";
            lost++;
        }
        played++;

        if(opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResults(null, oppScore, ourScore);
        }
    }

    public int ranking(){
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(TeamClass<T> team){
        if(this.ranking() > team.ranking()){
            return 1;
        } else if(this.ranking() < team.ranking()){
            return -1;
        }else{
            return 0;
        }
    }

}
