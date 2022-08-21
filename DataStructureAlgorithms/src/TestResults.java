    import java.util.stream.*;
import java.util.*;
    import java.util.concurrent.Callable;
     class TestResults
    {

    }



    interface Reptile {
        ReptileEgg lay();
    }

    class FireDragon implements Reptile {
        public FireDragon() {
        }

        public static void main(String[] args) throws Exception {
            FireDragon fireDragon = new FireDragon();
            System.out.println(fireDragon instanceof Reptile);
        }

        @Override
        public ReptileEgg lay() {
            return null;
        }
    }

    class ReptileEgg {
        public ReptileEgg(Callable<Reptile> createReptile) throws Exception {

            if()

            throw new IllegalStateException("Waiting to be implemented.");
        }

        public Reptile hatch() throws Exception {
            try{
                List<Reptile> species = new Reptile();
                return species.add(new FireDragon);
            }catch(Exception e){
                throw new UnsupportedOperationException("Waiting to be implemented.");

            }
        }
    }

