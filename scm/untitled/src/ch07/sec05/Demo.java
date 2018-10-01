package ch07.sec05;

import java.util.List;
import java.util.RandomAccess;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 10000)
                .boxed()
                .collect(toList());

        swap(list, 50, 200);
    }

    public static void swap(List<?> list, int i, int j) {
        if(list instanceof RandomAccess) {
            helper(list, i, j);
            return;
        }

        throw new UnsupportedOperationException("not implements RandomAccess");
    }

    private static <T> void helper(List<T> list, int i, int j) {
        T element = list.get(i);
        list.set(i, list.get(j));
        list.set(j, element);
    }
}
