package ch10.sec02;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncDemo {
    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        String urlString = "http://horstmann.com";
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        HttpClient client = HttpClient.newBuilder()
                .executor(executor)
                .build();
        HttpRequest request
                = HttpRequest.newBuilder(new URI(urlString)).GET().build();
        // 비동기로 웹페이지에서 값을 가져온다.
        client.sendAsync(request, HttpResponse.BodyHandler.asString())
                .thenApply(HttpResponse::body)
                .whenComplete((s, t) -> {
                    if (t == null) System.out.println(s);
                    else t.printStackTrace();
                    executor.shutdown();
                });

        // Thread.sleep(5000);
        // System.out.println("httpclient run1");
        executor.awaitTermination(10, TimeUnit.MINUTES);
        // System.out.println("httpclient run2");
    }
}
