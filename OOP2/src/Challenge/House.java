package Challenge;

public class House {
    private Sofa sofa;
    private Television television;
    private Dimensions dimensions;

    public House(Sofa sofa, Television television, Dimensions dimensions) {
        this.sofa = sofa;
        this.television = television;
        this.dimensions = dimensions;
    }

    public Sofa getSofa() {
        return sofa;
    }

    public Television getTelevision() {
        return television;
    }

    public void adventure() {

        System.out.println("Its Chilling Time.... " + television.premium() + " ... " + sofa.stretch());;
    }

}
