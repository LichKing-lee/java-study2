1. 행위가 완전 달라질 때는 상속으로 재정의를 하지 말아야 한다 (리스코프 치환 원칙)
    OOP적으로 맞는지 고민해야 한다 (상속을 할 때)

```
@Override

```

2. @override 실수하지말자 Object로 받아야 함, 아니면 두개 선언하는 꼴?
```java

@Override
equals(Object obj) {
    
}
```
    
3. 상속을 방지하는 방법

    1. Use final
    2. Use private constructors(생성자)


181page 익명 서브 클래스 전까지