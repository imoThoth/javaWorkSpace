public class Main {

    public static void main(String[] args) {

        // TODO implement java docs nested class examples
        // first create the outer class
        GearBox mcLaren = new GearBox(6);
        // use reference to call inner class, when class is public
        //  GearBox.Gear first = mcLaren.new Gear(1, 12.3);

        mcLaren.addGear(1, 5.3);
        mcLaren.addGear(2, 10.6);
        mcLaren.addGear(3, 15.9);

        mcLaren.operateClutch(true);

        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));
    }
}
