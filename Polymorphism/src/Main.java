
class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot(){
        return "No plot here";
    }

    public String getName(){
        return name;
    }
}

class Jaws extends Movie {
    public Jaws(){
        super("Jaws");
    }

    public String plot(){
        return "Shark eats people, people get scared";
    }
}

class IndependenceDay extends Movie {
    public IndependenceDay(){
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Will Smith Slaps aliens back to their planet";
    }
}

class MazeRunner extends Movie {

    public MazeRunner(){
        super("Maze Runner");
    }

    @Override
    public String plot(){
        return "Kids try and escape from a maze";
    }
}

class StarWars extends Movie {

    public StarWars(){
        super("StarWars");
    }

    @Override
    public String plot() {
        return "Wars among the stars";
    }
}

class Forgetable extends Movie{
    public Forgetable(){
        super("Forgettable");
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        for(int i = 0; i < 11; i++){
            Movie movie = randomMovie();
            System.out.println("Movie #" + i + " : " + movie.getName()
                                + "\n" + "Plot: "
                                + movie.plot() + "\n");
        }
    }

    public static Movie randomMovie(){
        int random = (int)(Math.random() * 5) + 1;
        System.out.println("Random number generated is " + random);
        switch(random){
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgetable();
        }
        return null;
    }
}
