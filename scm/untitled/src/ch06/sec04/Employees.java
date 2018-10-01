package ch06.sec04;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Employees {
    // 6.4.1
    // ArrayList에는 Employee를 상속받은 클래스만 사용가능
    public static void printNames(ArrayList<? extends Employee> staff) {
        for (int i = 0; i < staff.size(); i++) {
            Employee e = staff.get(i);
            System.out.println(e.getName());
        }
    }

    // 6.4.2
    public static void printAll1(Employee[] staff, Predicate<Employee> filter) {
        for (Employee e : staff) 
            if (filter.test(e))
                System.out.println(e.getName());
    }

    //
    public static void printAll2(Employee[] staff, Predicate<? super Employee> filter) {
        for (Employee e : staff) 
            if (filter.test(e))
                System.out.println(e.getName());
    }
    
    public static void main(String[] args) {
        // 6.4.1
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Jane", 10000));
        staff.add(new Employee("Tom", 20000));
        // printNames(staff);

        Employee[] employees = {
          new Employee("Fred", 50000),
          new Employee("Wilma", 60000),
        };

        //
        printAll1(employees, e -> e.getSalary() > 100000);
        printAll2(employees, e -> e.getSalary() > 100000);
        Predicate<Object> evenLength = e -> e.toString().length() % 2 == 0;
        // Object -> Employee : 서로 아규먼트 타입이 달라서 에러발생
        // printAll1(employees, evenLength);
        printAll2(employees, evenLength);
    }
}
