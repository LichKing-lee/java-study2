package ch07.sec02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aa", "bb", "cc");

// a
        for(Iterator<String> iterator = strings.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next().toUpperCase());
        }

// b
        for(int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i).toUpperCase());
        }

// c
        strings.replaceAll(String::toUpperCase);
        strings.forEach(System.out::println);
    }
}
