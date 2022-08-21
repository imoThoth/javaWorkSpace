public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal(1, 1, 1, 5, "Animal");

        Dog dog = new Dog(8, 20, "Yorkie", 2, 4, 1, 20, "silky");

        dog.eat();

//        dog.move(5);

        dog.walk();
        dog.run();
    }
}
