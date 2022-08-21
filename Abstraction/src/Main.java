public class Main {

    public static void main(String[] args) {
	// write your code here
        Dog dog = new Dog("Labrador");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Seagull");
        parrot.fly();
        parrot.breathe();
        parrot.eat();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
        penguin.breathe();
        penguin.eat();

    }
}
