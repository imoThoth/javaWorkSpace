import java.rmi.UnexpectedException;

public class Main {

    public static void main(String[] args) {
	    String test = "yes";

	    try{
            System.out.println("start try");
            doRisky(test);
            System.out.println("end try");
        }catch(ScaryException se){
            System.out.println("Scary Exception");
        }finally{
            System.out.println("We will always run");
        }

        System.out.println("End of main");
    }

    static void doRisky(String test) throws ScaryException{
        System.out.println("start risky");
        if("yes".equals(test)){
            throw new ScaryException();
        }
        System.out.println("End Scary Scenario");
    }

    class Laundry{
        public void doLaundry() throws PantsException, LingerieException{

        }
    }

    class WashingMachine{
        Laundry laundry = new Laundry();

        public void go(){
            try{
                laundry.doLaundry();
            }catch (PantsException pe ){
                // land if throws a pants exception
            }catch (LingerieException le){
                //lands if throws lingerie exception
            }
        }
    }

    static class ScaryException extends Exception{

    }

    static class PantsException extends Exception{

    }

    static class LingerieException extends Exception{

    }
}
