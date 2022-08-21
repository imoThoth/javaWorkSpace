public class Main {

    public static void main(String[] args) {

        Dimension smallDimension = new Dimension(20, 20, 5);
        Case firstCase = new Case("220B", "Dell", "240", smallDimension);

        Monitor firstMonitor = new Monitor("27 Inch B", "Dell", 27, new Resolution(2540, 1440));

        Motherboard firstMotherBoard = new Motherboard("BJ-200", "Dell", 10, 6, "v1.02");

        PC firstPC = new PC(firstCase, firstMonitor, firstMotherBoard);

        firstPC.getMonitor(); // using a . after will get all methods associate with monitors
        firstPC.getMotherboard(); // using a . after will get all methods associated with Motherboard
        firstPC.getMotherboard().loadProgramme("Accessing Windows");

        firstPC.powerUp();


    }
}
