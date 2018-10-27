package ch10.sec01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 2개의 스레드가 서로 실행하면서 교차로 출력한다.
public class RunnableDemo {
    public static void main(String[] args) {
        Runnable hellos = () -> {
            for (int i = 1; i <= 1000; i++)
                System.out.println("Hello " + i);
        };
        Runnable goodbyes = () -> {
            for (int i = 1; i <= 1000; i++)
                System.out.println("Goodbye " + i);
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        // Thread 갯수를 제한한다.
        // Executors.newFixedThreadPool(2);
        executor.execute(hellos);
        executor.execute(goodbyes);
        executor.shutdown();
    }
}
