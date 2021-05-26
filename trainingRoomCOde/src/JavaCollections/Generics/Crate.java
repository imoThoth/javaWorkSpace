package JavaCollections.Generics;

/**Generic Methods
 * -  Formal types parameters, declared on method level
 *
 *
 *
 * **/

public class Crate <T> {
   private T contents;

   public T emptyCrate(){
       return contents;
   }

   public void packCrate(T contents){

   }

//Static methods run before class start, having the method runs with generics
//This can also be done with regular methods
   //method parameter is generic type T
   //return type is a Crate T
   //Before return type, a formal type parameter of T is declared
   public static <T> Crate<T> ship(T t){
      System.out.println("Preparing " + t);
      return new Crate<T>();
   }

   //Ways of Creating Generic Methods
   //creates generic method without a return type
   public static <T> void sink(T t){ }

   //The return type being the formal parameter
   public static <T> T carry(T t){ return t;}
}
