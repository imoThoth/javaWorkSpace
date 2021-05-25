package Challenge;

public class Television {
    private String color;
    private Dimensions dimensions;
    private String type;
    private Boolean cable = false;

    public Television(String color, Dimensions dimensions, String type, Boolean cable) {
        this.color = color;
        this.dimensions = dimensions;
        this.type = type;
        this.cable = cable;
    }

    public String getColor() {
        return color;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getType() {
        return type;
    }

    public String premium(){
        if(cable){
          return "Enjoy the Good Life";
        }else{
            return "Get Cable to Enjoy Ad Free Content";
        }
    }
}
