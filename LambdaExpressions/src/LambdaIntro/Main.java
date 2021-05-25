package LambdaIntro;

public class Main {
    /**
     * Lambda allows devs to work with interfaces providing a single method
     *  May also be used in places which uses annonymous classes
     *  All lambdas can be divided into three parts,
     *  Argument/Parameter List, Arrow Token, Body
     */

    public static void main(String[] args) {

        new Thread(new CodeToRun()).start();

        //Using an annonymous class to create threads
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A whole new runnable");
            }
        }).start();

        //Using a lambda expression
        //Empty argument/params list, Arrow token, println Body
        new Thread(() -> System.out.println("Using a lambda and annonymous class"))
                .start();
    }
}

class CodeToRun implements Runnable{
    @Override
    public void run(){
        System.out.println("Printing from the runnable");
    }
}
