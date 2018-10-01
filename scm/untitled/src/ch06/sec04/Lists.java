package ch06.sec04;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    // List의 각 요소들이 null인지 체크한다. null이면 true를 리턴
    public static boolean hasNulls(List<?> elements) {
        for (Object e : elements) {
            if (e == null) return true;
        }
        return false;
    }

    // 6.4.4
    // 책에서는 ArrayList인데, 소스는 List임.
    public static boolean hasNulls2(ArrayList<?> elements) {
        for (Object e : elements) {
            if (e == null) return true;
        }
        return false;
    }

    // 6.4.4
    public static <T> boolean hasNulls3(ArrayList<T> elements) {
        for (Object e : elements) {
            if (e == null) return true;
        }
        return false;
    }

    // 6.4.5
    // 아래 함수는 에러
    // ? 를 타입인수로 사용가능하지만, 타입으로는 사용불가
    /*
    public static void swap(ArrayList<?> elements, int i,int j) {
        ? temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
    */

    // 이렇게 사용하는것과 아래의 T를 ? 로 사용하는것과 차이는?
    // P260 맨 아래 참조
    public static <T> void swap2(ArrayList<T> elements, int i,int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }


    // 6.4.5
    // 아래와 같이 swapHelper메소드를 사용하여 우회하는 방법으로 해결한다.
    public static void swap(ArrayList<?> elements, int i, int j) {
        swapHelper(elements, i, j);
    }
    
    private static <T> void swapHelper(ArrayList<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
