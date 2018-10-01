package ch06.sec02;

import java.util.Arrays;

public class ArrUtilDemo {
    public static void main(String[] args) {
        String[] friends = { "Peter", "Paul", "Mary" };
        // public static <T> void swap(T[] array, int i, int j)
        // 컴파일러가 T[] array가 String[]형이라서 <T>도 String이라고 추론한다.
        ArrayUtil.swap(friends, 0, 1);
        System.out.println(Arrays.toString(friends));

        // 주석을 해제하면 오류 메시지를 확인할 수 있다.
        // private method라서 에러발생
        //Double[] result = Arrays.swap(0, 1, 1.5, 2, 3);
    }
}
