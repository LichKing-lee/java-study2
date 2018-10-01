package ch07.sec04;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 10000)
                .boxed()
                .collect(toList());

        for (Integer i : list) {
            list.add(99);
        }
    }
}
