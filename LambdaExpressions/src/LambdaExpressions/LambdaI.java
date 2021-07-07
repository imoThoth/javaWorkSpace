package LambdaExpressions;


import LambdaIntro.MainCont;



interface UpperConcatt {
    String upperAndConcatt(String s1, String s2);
}

class AnotherClass{
    public String doSomething(){

        UpperConcatt uc = (s1, s2) -> {
            System.out.println("The lambda expressions class is: " + getClass().getSimpleName());
            String result = s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };
        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return LambdaI.doStringStuff(uc, "String 1", "String 2");
    }
    //Uses lambda as an expression
    //When the code runs, the thread sleeps, and number is printed as a value
    //Remembering that lambdas are anonymous classes, if the value of number changes
    //it is not registered by the compiler as it is outside a code scope
    //variables inside anonymous classes must be final or EFFECTIVELY final
        public void printValue(){
        int number = 25;
        Runnable r = () -> {
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };
        new Thread(r).start();
        //number++; How does this line change the code?
        }
}

public class LambdaI {

    public static void main(String[] args){

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcatt uc, String s1, String s2) {
        return uc.upperAndConcatt(s1, s2);
    }
}
