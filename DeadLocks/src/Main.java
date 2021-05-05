public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();


    public static void main(String[] args) {
        // write your code here
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread1: has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {

                }
                System.out.println("Thread 1 waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 1: has lock1 and lock2");
                }
                System.out.println("Thread 1: realeased lock2");
            }
            System.out.println("Thread 1: Released lock1.. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2: has lock 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }

                System.out.println("Thread 2: waiting for lock 1");
                synchronized (lock2) {
                    System.out.println("Thread 2: Has lock 2 and lock 1");
                }
                System.out.println("Thread 2: released lock 1");
            }
            System.out.println("Thread 2: released lock2. Exiting...");
        }

    }
}

