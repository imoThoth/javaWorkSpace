public class main {
    public static void main(String[] args) {
        System.out.println("From second module");

        EncapsulatedPlayer player = new EncapsulatedPlayer("Boblot", 200, "Spear");
        System.out.println("Health is " + player.getHealth());
    }
}
