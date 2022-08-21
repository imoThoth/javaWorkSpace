public class ScopeAndFunctional {

    public String doSomething(){

        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            System.out.println("The value from result is " + result);

            //variables used within lambda must be final or effectively final(value doesnt change when app runs)
            System.out.println("I within the lambda expression " + i);
            System.out.println("The lambda class is named: " + getClass().getSimpleName());
            return result;
        };

        System.out.println("The current class is named: " + getClass().getSimpleName());

        printValue();
        return Main.doStringStuff(uc, "Becoming", "Pragmatic");
    }

    public void printValue(){
        int number = 25;

        Runnable r = () -> {
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("The value within printValue method is " + number);
        };

        new Thread(r).start();
    }
}
