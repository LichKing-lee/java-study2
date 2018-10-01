package ch06.sec03;

import java.io.PrintStream;
import java.util.ArrayList;

public class CloseablesDemo {
    public static void main(String[] args) throws Exception {
        PrintStream p1 = new PrintStream("/tmp/1");
        PrintStream p2 = new PrintStream("/tmp/2");
        ArrayList<PrintStream> ps = new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        // ps는 AutoCloseable를 implement 받아야만 사용가능
        // PrintStream 은 interface Closeable 를  implements 하고, Closeable은 AutoCloseable 를 extends를 받아서 사용가능
        // Interface인 AutoCloseable의 메소드에 void close() 가 정의되어있음.
        Closeables.closeAll(ps);
    }
}
