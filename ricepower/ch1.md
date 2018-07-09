### Problem 01
```java
public class Problem1 {
    
	public static void main(String[] args) {
        int number = 99;

        System.out.println("Binary : " + Integer.toBinaryString(number));
        System.out.println("Oct : " + Integer.toOctalString(number));
        System.out.println("Hex : " + Integer.toHexString(number));
    }
}
```

### Problem 02
```java
public class Problem2 {
    
	public static final int ANGLE = 360;

    public  static void main(String[] args) {
        int positiveAngle = 730;
        int negativeAngle = -50;

        System.out.println(positiveAngle % ANGLE);
        System.out.println((negativeAngle % ANGLE) + ANGLE);

        System.out.println(Math.floorMod(positiveAngle, ANGLE));
        System.out.println(Math.floorMod(negativeAngle, ANGLE));
    }
}
```