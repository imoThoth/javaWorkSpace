public class Fibonacci {

    public static long fib(int n){

        if((n ==0 || n== 1))
            return n;
        else

        return fib(n - 1) + fib( n - 2);
    }


    public static void main(String[] args) {

        long fib20 = fib(20);
        System.out.println("Fibonacci First 20: " + fib20);

        for (int i = 0; i < 10; i++){
            System.out.print( fib(i) + " ,");
        }
    }
}
