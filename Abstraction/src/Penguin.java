public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Flapping wings, at tremendous speeds, underwater");
    }
}
