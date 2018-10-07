package ch08.sec00;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class Test2 {
    // ----------------------- 연습문제 13 ----------------------------------------
//    public static void main(String[] args) {
//        List<String> list1 = Arrays.asList("a", "b", "c");
//        List<String> list2 = Arrays.asList("1", "2", "3", "4", "5", "6");
//
//        zip(list1.stream(), list2.stream()).forEach(System.out::println);
//    }
//
//    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
//        Queue<T> list1 = first.collect(toCollection(LinkedList::new));
//        Queue<T> list2 = second.collect(toCollection(LinkedList::new));
//
//        int size = list1.size() > list2.size() ? list1.size() : list2.size();
//
//        List<T> result = new ArrayList<>();
//        for(int i = 0; i < size*2; i++) {
//            if(i % 2 == 0) {
//                result.add(poll(list1));
//            }else {
//                result.add(poll(list2));
//            }
//        }
//
//        return result.stream();
//    }
//
//    private static <T> T poll(Queue<T> queue) {
//        return Optional.ofNullable(queue.poll()).orElse(null);
//    }

    // ----------------------- 연습문제 14 ----------------------------------------
//    public static void main(String[] args) {
//        List<String> list1 = Arrays.asList("a", "b", "c");
//        List<String> list2 = Arrays.asList("1", "2", "3", "4", "5", "6");
//
//        List<String> result1 = recude1(list1, list2);
//        System.out.println(result1);
//
//        List<String> result2 = recude2(list1, list2);
//        System.out.println(result2);
//
//        List<String> result3 = recude3(list1, list2);
//        System.out.println(result3);
//    }
//
//    private static List<String> recude1(List<String> list1, List<String> list2) {
//        return Stream.of(list1, list2)
//                .reduce((l1, l2) -> {
//                    List<String> result = new ArrayList<>(l1);
//                    result.addAll(l2);
//
//                    return result;
//                }).orElseGet(ArrayList::new);
//    }
//
//    private static List<String> recude2(List<String> list1, List<String> list2) {
//        return Stream.of(list1, list2)
//                .reduce(new ArrayList<>(), (l1, l2) -> {
//                    List<String> result = new ArrayList<>(l1);
//                    result.addAll(l2);
//
//                    return result;
//                });
//    }
//
//    private static List<String> recude3(List<String> list1, List<String> list2) {
//        return Stream.of(list1, list2)
//                .reduce(new ArrayList<>(), (List<String> list3, List<String> list4) -> {
//                    List<String> l = new ArrayList<>(list3);
//                    l.addAll(list4);
//
//                    return l;
//                }, (list5, list6) -> {
//                    List<String> l = new ArrayList<>(list5);
//                    l.addAll(list6);
//
//                    return l;
//                });
//    }

    // ----------------------- 연습문제 18 ----------------------------------------
    /*
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 1, 1, 2, 3, 1, 2, 3, 3);
        //List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> result = list.parallelStream().map(Arrays::asList)
                .reduce((l1, l2) -> {
                    System.out.println(Thread.currentThread().getName() + "::" + l1 + ":" + l2);
                    List<Integer> l3 = new ArrayList<>(l1);
                    if(l1.get(l1.size()-1) == l2.get(0)) {
                        l3.addAll(l2.subList(1,l2.size()));
                        // return l1;
                    }
                    else {
                        System.out.println(Thread.currentThread().getName() + "::" + "add :" + l1 + ":" + l2);
                        l3.addAll(l2);
                    }
                    return l3;

                } ).orElseGet(ArrayList::new);

        System.out.println(result);


        class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return name;
            }
        }

        List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));

        persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s [%s]\n",
                                    sum, p, Thread.currentThread().getName());
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s [%s]\n",
                                    sum1, sum2, Thread.currentThread().getName());
                            return sum1 + sum2;
                        });

    }
*/

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 1, 2, 3, 3);
        List<Integer> result = list.stream().map(Arrays::asList)
                .reduce((l1, l2) -> {
                    List<Integer> l3 = new ArrayList<>(l1);
                    if(l1.get(l1.size()-1) == l2.get(0)) {
                        l3.addAll(l2.subList(1,l2.size()));
                    }
                    else {
                        l3.addAll(l2);
                    }
                    return l3;
                }).orElseGet(ArrayList::new);

        System.out.println(result);
    }

}
