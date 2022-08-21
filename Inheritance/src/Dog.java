//extend keywords allow us to use inheritance
public class Dog extends Animal {

    //create state unique to dogs
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(int size, int weight, String name, int eyes, int legs, int tail, int teeth, String coat) {

        //brain and body not defined in constructor...values are known
        super(1, 1, size, weight, name); //TODO add notes to superForDummies
        this.eyes = eyes;
        this.legs = legs;
        this. tail = tail;
        this.teeth = teeth;
        this.coat = coat;

    }

    // behaviour specific to dog class
    private void chew(){
        System.out.println("Dog is now chewing");
    }

    //creates version of animal method eat
    @Override
    public void eat() {
        System.out.println("Override, Dog is eating");
        chew();
        super.eat();
    }

    public void walk(){
//        System.out.println("Call parent movement method");
        super.move(5);
        System.out.println("Dog is walking");
    }

    public void moveLegs(int speed){
        System.out.println("Moving Legs to walk");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog moving with legs");
        moveLegs(speed);
        super.move(speed);
    }

    public void run(){
        move(15);
        System.out.println("Dog is running");
    }


}
