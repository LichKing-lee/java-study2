package ch10.ch07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class LockDemo {
    public static int count; // 여러 스레드가 공유한다.
    public static Lock countLock = new ReentrantLock(); // 여러 스레드가 공유한다.
    private Object lock = "LOCK2";

    public void func(){
        synchronized (lock) {
            for(int i=0;i<1000;i++) {
                count++;
            }
        }
    }

    public void print(){
        synchronized (lock) {
            for(int i=0;i<1000;i++) {
                System.out.println("LockDemo : i=" +i);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        LockDemo demo1 = new LockDemo();
        LockDemo demo2 = new LockDemo();
        Exam demo3 = new Exam();

        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable hellos = () -> {
            demo1.print();
        };
        Runnable goodbyes = () -> {
            demo3.print();
        };

        executor.execute(hellos);
        executor.execute(goodbyes);

/*
        for (int i = 1; i <= 100; i++) {
            Runnable task = () -> {
                demo1.func();
                demo2.func();
            };
            executor.execute(task);
        }
*/

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("Final value: " + count);
    }
}
