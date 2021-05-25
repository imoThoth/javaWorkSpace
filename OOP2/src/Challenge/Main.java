package Challenge;

import java.awt.*;

public class Main {

    public static void main(String[] args){

        Dimensions comfyDimensions = new Dimensions(300,250,60);
        Dimensions oldDimensions = new Dimensions(300,250,60);
        Dimensions teleDimensions = new Dimensions(190,200,60);
        Dimensions houseDimensions = new Dimensions(1000,1000,1000);
        Dimensions oldHouseDimensions = new Dimensions(800,800,800);



        Sofa comfort = new Sofa(0, comfyDimensions, "brown", true);
        Sofa basicSofa = new Sofa(4, oldDimensions, "rusty", false);

        Television allChannels = new Television("Black", teleDimensions,"new", true);
        Television fewChannels = new Television("Black", teleDimensions,"old", false);

        House yard = new House(comfort, allChannels, houseDimensions);
        House oldYard = new House(basicSofa, fewChannels, oldHouseDimensions);

        System.out.println(comfort.getColour());
        System.out.println(comfort.getRecliner());
        System.out.println("The New Yard");
        yard.adventure();
        System.out.println("The old Yard");
        oldYard.adventure();
    }
}
