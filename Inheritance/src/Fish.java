public class Fish extends Animal {

    // unique state
    private int gills;
    private int eyes;
    private int fins;

    public Fish(int size, int weight, String name, int gills, int eyes, int fins) {
        super(1, 1, size, weight, name);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    public void rest(){

    }

    private void moveMuscles(){

    }

    private void moveBackFin(){

    }

    private void swim(int speed){
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }
}
