package ch10.sec;

// 1. private로 Lock을 지정하여, 값이 변할수가 있다.
// 2. LOCK를 이용하는 다른 클래스의 영향을 받는다. 문자열을 사용하지 말고 객체를 사용해야함 ( private Object myLock = new Object(); )
public class Stack {
    // final 로 지정하여 재지정을 막아야한다.
    private Object myLock = "LOCK";

    public void push(Object newValue) {
        synchronized (myLock) {

        }
    }
}
