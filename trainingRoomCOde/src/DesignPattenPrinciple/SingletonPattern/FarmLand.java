package DesignPattenPrinciple.SingletonPattern;

/**
 * Singleton are based used when accessing a single set of data
 * e.g Application configuration data and Reusable data caches
 * */


/*The Singleton Pattern
* -Create one instance of object in memory which can be shared throughout application by classes and threads
* -This globally shared object is reffered to as a singleton
* */

//singleton classes are usually marked final
class HayStorage{
    private int quantity = 0;

    //singleton constructors are marked private
    //prevents other classes from instantiating a new singleton object
    //this causes all singleton classes to be essentially final
    private HayStorage(){}

    //creates a singleton called instance... instance
    //singletons are created using the private static methid
    private static final HayStorage instance = new HayStorage();

    //allows us to access the singleton
    //singleton method uses a public static
    public static HayStorage getInstance(){
        return instance;
    }
    //"synchronised keyword" prevents concurrent access
    public synchronized void addHay(int amount){
        quantity += amount;
    }
    public synchronized boolean removeHay(int amount){
        if(quantity < amount) return false;
        quantity -= amount;
        return true;
    }
    public synchronized int getHayQuantity(){
        return quantity;
    }
}

//To use a singleton class like HayStorage
//you call the instance, and then access the method of your choosing
//if there were multiple Llama trainers, they would all be calling the same instance
class LlamaTrainer {
    public boolean feedLlamas(int numberofLlamas){

        int amountNeeded = 5 * numberofLlamas;
        HayStorage hayStorage = HayStorage.getInstance();
        if(hayStorage.getHayQuantity() < amountNeeded){
            hayStorage.addHay(amountNeeded + 10);
        }
        boolean fed = hayStorage.removeHay(amountNeeded);
        if(fed) System.out.println("Llamas have been fed");
        return fed;
    }
}

/**Like HayStorate, Staff register instantiates the singleton at time of creation
 * Static initialisation allows dev to handles cases where constructor throws exception
 *the reference can be marked final, because it is created once the class is loaded
 * */

class StaffRegister{
    private static final StaffRegister instance;

    static {//creates a singleton when class is loaded... reference type StaffRegiste
        instance = new StaffRegister();
    }
    private StaffRegister(){
    }
    public static StaffRegister getInstance(){
        return instance;
    }
}

//Using Lazy instantiation to generate a singleton
//Lazy instantiation = Creates reusable object first time it is requested
//Removes thread-safety
class VisitorTicketTracker{
    //Declares a singleton called instance
    private static VisitorTicketTracker instance;
    private VisitorTicketTracker(){}

    //instantiates/creates a new singleton using the getInstance method
    //synchronised adds thread safety to instance creation
    public static synchronized VisitorTicketTracker getInstance(){
        if(instance == null){
            instance = new VisitorTicketTracker();
        }
        return instance;
    }
}
public class FarmLand {
}
