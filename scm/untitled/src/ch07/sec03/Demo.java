package ch07.sec03;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Set<String> set1 = createSet1();
        Set<String> set2 = createSet2();

        // 합집합
        set1.addAll(set2);

        set1.forEach(System.out::println);

        System.out.println("@@@");

        // 교집합
        set1 = createSet1();
        set2 = createSet2();

        set1.retainAll(set2);
        set1.forEach(System.out::println);

        System.out.println("@@@");

        // 차집합
        set1 = createSet1();
        set2 = createSet2();

        set1.removeAll(set2);
        set1.forEach(System.out::println);
    }

    private static Set<String> createSet1() {
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("c");
        set.add("e");

        return set;
    }

    private static Set<String> createSet2() {
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("c");

        return set;
    }
}
