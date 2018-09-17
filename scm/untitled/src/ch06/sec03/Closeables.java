package ch06.sec03;

import java.util.ArrayList;

public class Closeables {
    // T는 AutoCloseable를 상속받은 얘들만 사용가능하다.
    // T extends AutoCloseable  & Appendable 이렇게 다중 경계를 지정할수도 있다.
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        for (T elem : elems) elem.close();
    }
}
