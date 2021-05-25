package Challenge;

public class Sofa {
    private int age;
    private Dimensions dimensions;
    private String colour;
    private Boolean recliner = false;

    public Sofa(int age, Dimensions dimensions, String colour, Boolean recliner) {
        this.age = age;
        this.dimensions = dimensions;
        this.colour = colour;
        this.recliner = recliner;
    }

    public int getAge() {
        return age;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getColour() {
        return colour;
    }

    public Boolean getRecliner() {
        return recliner;
    }

    public String stretch(){
        if(recliner) {
            return "An expensive stretch";
        } else{
            return "An ache of a time";
        }
    }
}
