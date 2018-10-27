package ch10.sec;

import java.net.Inet4Address;
import java.util.concurrent.*;

// main
public class MainThreadExample {
    public static void main(String[] args) {
        // thread 1
        Thread t1  = new Thread(()->System.out.println("aaa"));

        // thread 2
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("bbbb");
            }
        };

        // thread 3
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->System.out.println("aaaa"));


        Future<Integer> future2 = service.submit(()->1);

        // callable
        // 컨슈머
        //
        // 서플라이어, supplier
        // CompletableFuture<Integer> fu = CompletableFuture.supplyAsync(()->{  })


        // java script == 콜백지옥!!!!! 해결책 :  프라미스가 대세이다가 어웨잇어씽크가 대세..



        // rxJava ==> 안드로이드에서 주로 사용???





        // 스레드풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        System.out.println("[작업 처리 요청]");

        Callable callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                }

                return sum;
            }
        };

        Future<Integer> future = executorService.submit(callable);

        try {
            int sum = future.get();
            System.out.println("[처리 결과] " + sum);
            System.out.println("[작업 처리 완료]");
        } catch (Exception e) {
            System.out.println("[실행 예외 발생] " + e.getMessage());
        }

        executorService.shutdown(); // 작업 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드풀을 종료

    }
}