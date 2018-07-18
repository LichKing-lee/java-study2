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

### Problem 03
```java
public class Problem3 {

    public static void main(String[] args) {
        int a = 99;
        int b = 101;
        int c = 11;

        System.out.println( (a >= b ? a : b) > c ? (a >= b ? a : b) : c);
        System.out.println(Math.max(Math.max(a, b), c));
    }
}
```

### Problem 05
```java
public class Problem5 {

    public static void main(String[] args) {
        double bigNumber = 123456789123456d;
        System.out.println((int) bigNumber); // Integer.MAX_VALUE;
    }
}

```

### Problem 06
```java
public class Problem6 {

    public static void main(String[] args) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= 1000; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(result);
    }
}
```

### Problem 08
```java
public class Problem8 {

    public static void main(String[] args) {
        String testCase = "Hello World     Java 9";
        String[] splitString = testCase.split("\\s+");
        for (String str : splitString) {
            System.out.println(str);
        }
    }
}
```

### Problem 09
```java
public class Problem9 {

    public static void main(String[] args) {
        // .equals() 동등성
        // == 동일성
        String a = new String("Hello");
        String b = new String("Hello");

        System.out.println(a.equals(b));
        System.out.println(a == b);
    }
}
```

### Problem 13
```java
public class Problem13 {

    public static void main(String[] args) {
        ArrayList<Integer> lottery = new ArrayList<>();
        for (int i = 0; i < 49; i++) {
            lottery.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int number = new Random().nextInt(lottery.size()) + 1;
            result.add(lottery.get(number));
            lottery.remove(number);
        }

        Collections.sort(result);
        System.out.println(result);
    }
}
```

### Problem 15
```java
public class Problem15 {

    public static void main(String[] args) {
        int number = 6;

        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            pascal.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0) pascal.get(i).add(1);
                else if (i == j) pascal.get(i).add(1);
                else pascal.get(i).add(pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j));
            }
        }

        System.out.println(pascal);
    }
}
```

### Problem 16
```java
public class Problem16 {

    public static void main(String[] args) {
        System.out.println(average(10));
        System.out.println(average(10, 11));
    }

    public static double average(double value, double... values) {
        double sum = value;
        for (double v : values) sum += v;
        return values.length == 0 ? value : sum / (values.length + 1);
    }
}
```