package ch06.sec01;

public class EntryDemo {
    public static void main(String[] args) {
        // generic class 는 Type parameter가 한개이상있는 클래스
        Entry<String,Integer> entry = new Entry<>("scm",40);
        System.out.println("key:" + entry.getKey());
        System.out.println("value:" + entry.getValue());
    }
}
