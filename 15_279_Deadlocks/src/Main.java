public class Main {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (Main.lock1) {
                System.out.println("Thread 1: has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 1: waiting for lock 2");
                synchronized (Main.lock2) {
                    System.out.println("Thread 1: has lock 2");
                }
                System.out.println("Thread 1: released lock 2");
            }
            System.out.println("Thread 1: released lock1. exiting");
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            //this is going to flip it so that the locks are in the same order as Thread1
            // this avoids deadlock
            synchronized (Main.lock1) {
                System.out.println("Thread 2: has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2: waiting for lock2");
                synchronized (Main.lock2) {
                    System.out.println("Thread 2: has lock2 and lock1");
                }
                System.out.println("Thread 2: released lock 1");
            }
            System.out.println("Thread 2: released lock 2. Exiting...");
        }
    }
}