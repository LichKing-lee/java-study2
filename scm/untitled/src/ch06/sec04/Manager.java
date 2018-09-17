package ch06.sec04;

// 매니저 클래스
// 직원클래스를 상속받아 이름과 봉급 property를 가지고 있고,
// 보너스 property를 가지고 있다.
public class Manager extends Employee {
    private double bonus;
    
    public Manager(String name, double salary) {
        super(name, salary);
        bonus = 0;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    public double getSalary() { // 슈퍼클래스의 메서드를 오버라이드한다.
        return super.getSalary() + bonus;
    }
}
