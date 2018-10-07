package ch08.sec00;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {



    private static int prev;
    public static void main(String[] args) {

        ///////////////////////////////////////////////////////////
        // 기존의 정렬방법
//        String[] strArr = {"aaa", "ddd", "ccc"};
//        List<String> strList = Arrays.asList(strArr);
//        Arrays.sort(strArr);
//        Collections.sort(strList);
//
//        for(String str : strArr)
//            System.out.println(str);
//
//        for(String str : strList)
//            System.out.println(str);
        ///////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////
        // 스트림을 이용한 정렬방법
//        Stream<String> strStreamArr = Arrays.stream(strArr);
//        Stream<String> strStreamList = strList.stream();
//
//        strStreamArr.sorted().forEach(System.out::println);
//        strStreamList.sorted().forEach(System.out::println);
        ///////////////////////////////////////////////////////////

        // Error 발생. 스트림이 닫혀서 사용불가, 스트림은 1회용이다.
//        Stream<String> strStreamArr = Arrays.stream(strArr);
//        long num = strStreamArr.count();

        // 스트림을 사용하여 정렬한결과를 sortedList에 넣었다. 원본은 변하지 않는다.
//        List<String> sortedList = Arrays.stream(strArr).sorted().collect(Collectors.toList());

        // 이렇게 스트림을 사용하여 정렬과, 반복을 사용한 출력을, 한줄로 처리하였다.
//        Arrays.stream(strArr).sorted().forEach(System.out::println);


        // Collection Class는 모두 strimg() 메서드로 스트림을 생성할수있다.
//        List<Integer> list = Arrays.asList(1,2,3,4,5);
//        Stream<Integer> intStream = list.stream();

        // 배열을 Stream으로 만들때,
//        String[] strArr = {"aaa", "ddd", "ccc"};
//        Stream<String> strStream = Stream.of(strArr);
//        Stream<String> strStream2 = Arrays.stream(strArr);

        // 특정범위의 정수를 스트림으로 생성할때
//        IntStream intStream = IntStream.range(1, 5); // 1,2,3,4
//        IntStream intStream2 = IntStream.rangeClosed(1, 5); // 1,2,3,4,5


        ////////////////////////////////////////////////////////////////////////////////
        // 스트림을 이용한 난수생성하기
//        IntStream intStream = new Random().ints(); // 무한 스트림
//        IntStream intStream3 = new Random().ints(1,100);  // 1~100까지의 무한스트림
//        intStream.limit(5).forEach(System.out::println); // 5개의 요소만 출력
//        IntStream intStream2 = new Random().ints(5); // 크기가 5인 난수 스트림을 반환
//        intStream2.forEach(System.out::println);
        ////////////////////////////////////////////////////////////////////////////////

        // 람다식을 사용한 스트림생성방법
        ////////////////////////////////////////////////////////////////////////////////
//        Stream<Integer> evenStream = Stream.iterate(0, n->n+2); // 0,2,4,6 .....
//        Stream<Double> randomStream = Stream.generate(Math::random);
//
//        // 기본형 스트림 타입의 참조변수로 다룰수없다.
//        IntStream evenStream2 = Stream.iterate(0, n->n+2);  //error
//        DoubleStream randomStream2 = Stream.generate(Math::random);  //error
//
//        // 아래와 같이 mapToInt같은 메서드로 반환해야함
//        IntStream evenStream3 = Stream.iterate(0, n->n+2).mapToInt(Integer::valueOf);
//        Stream<Integer> stream = evenStream3.boxed();

        // Stream에서 파일 사용
        // Stream<Path>     Files.list(Path dir)

        // 빈스트림
//        Stream emptyStream = Stream.empty();

        ////////////////////////////////////////////////////////////////////////////////
        // 스트림 연결하기
//        String[] str1 = {"123", "456" };
//        String[] str2 = {"aaa", "bbb", "cc"};
//
//        Stream<String> strs1 = Stream.of(str1);
//        Stream<String> strs2 = Stream.of(str2);
//        Stream<String> strs3 = Stream.concat(strs1, strs2);
//        strs3.forEach(System.out::println);
        ////////////////////////////////////////////////////////////////////////////////



        /*
        Stream<Integer> values = Stream.of(1, 2, 2, 3, 3, 3, 4, 2);
        values = values.filter( x -> {
            boolean r = prev != x;
            prev = x;
            return r; })
                .peek(x -> { return; });
        values.forEach(System.out::println);
        */

        ///////////////// 연습문제3 //////////////////////////////////
        int[] values = {1, 4, 9, 16};
        Arrays.stream(values).forEach(System.out::println);

        ///////////////// 연습문제5 //////////////////////////////////
//        Stream<String> ret = codePoints("abcdefg");
//        ret.forEach(System.out::println);

        // codePoints 와 같은 기능을 수행한다.
        String target = "hello world";
        Stream<String> ret = IntStream.iterate(0, n -> n < target.length(), n -> n + 1).mapToObj(n -> target.substring(n, n + 1));
        IntStream.iterate(0, n -> n < target.length(), n -> n + 1)
                .mapToObj(n -> target.substring(n, n + 1))
                .forEach(System.out::println);
    }

    public static Stream<String> codePoints(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int j = s.offsetByCodePoints(i,1);
            result.add(s.substring(i,j));
            i = j;
        }
        return result.stream();
    }
}

