package DesignPattenPrinciple.interfacePackage;

interface Walk{
    boolean isQuadrupled();
    abstract double getMaxSpeed();
}

interface Run extends Walk{
    public abstract boolean canHuntWhileRunning();
    abstract double getMaxSpeed();
}

class Lion implements Run{
    public boolean isQuadrupled() {
        return true;
    }
    public boolean canHuntWhileRunning(){
        return true;
    }
    public double getMaxSpeed(){
        return 300.26;
    }

}
public class InterfacesCont {
    /**Interfaces may also extend other interfaces
     * This new interfaces now inherit all abstract method of its parent class
     *
     *
     * */
}
