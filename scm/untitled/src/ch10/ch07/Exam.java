package ch10.ch07;

public class Exam {
    private Object lock2 = "LOCK";


    public void print(){
        synchronized (lock2) {
            for(int i=0;i<1000;i++) {
                System.out.println("Exam : i=" +i);
                //count++;
            }
        }
    }
};
