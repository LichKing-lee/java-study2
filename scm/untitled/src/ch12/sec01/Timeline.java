package ch12.sec01;


import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Instant : 1970년1월1일0시0분0초 ==> 0
public class Timeline {

    public static void InstantObjectTest() {
        Instant current = Instant.now();
        System.out.println("Current Instant = "+ current);

        long epochSecond = current.getEpochSecond();
        System.out.println("Current Timestamp in seconds = " + epochSecond);

        long epochMilli = current.toEpochMilli();
        System.out.println("Current Timestamp in milli seconds = " + epochMilli);
        System.out.println();
    }


    public static void main(String[] args) {
        // Instant 객체 테스트
        InstantObjectTest();

        ////////////////////////////////////////////////////////////////////////////
        // Instant 객체를 사용한 실행시간측정
        Instant start = Instant.now();
        runAlgorithm();
        Instant end = Instant.now();
        // 시간차를 구한다.
        Duration timeElapsed = Duration.between(start, end);
        long millis = timeElapsed.toMillis();
        System.out.printf("%d milliseconds\n", millis);

        Instant start2 = Instant.now();
        runAlgorithm2();
        Instant end2 = Instant.now();
        Duration timeElapsed2 = Duration.between(start2, end2);
        System.out.printf("%d milliseconds\n", timeElapsed2.toMillis());
        boolean overTenTimesFaster = timeElapsed.multipliedBy(10).minus(timeElapsed2).isNegative();
        System.out.printf("The first algorithm is %smore than ten times faster",
                overTenTimesFaster ? "" : "not ");
        ////////////////////////////////////////////////////////////////////////////
    }

    public static void runAlgorithm() {
        int size = 10;
        List<Integer> list = new Random().ints().map(i -> i % 100).limit(size).boxed()
                .collect(Collectors.toList());
        Collections.sort(list);
        System.out.println(list);
    }

    public static void runAlgorithm2() {
        int size = 10;
        List<Integer> list = new Random().ints().map(i -> i % 100).limit(size).boxed()
                .collect(Collectors.toList());
        while (!IntStream.range(1, list.size()).allMatch(
                i -> list.get(i - 1).compareTo(list.get(i)) <= 0))
            Collections.shuffle(list);
        System.out.println(list);
    }
}