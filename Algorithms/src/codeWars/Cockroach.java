package codeWars;

//Convert km/ph to cm/per second
public class Cockroach {

    public static int cockroachSpeed(double x){
        // Good Luck!
        double operation1 = x * 100000;
        double operation2 = operation1 / 3600;
        int result = (int)operation2;

        return result;
    }
}
