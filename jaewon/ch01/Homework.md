
```java
public class P1 {

    public static void main(String[] args) {

        //정수를 읽어서 2진수, 8진수, 16진수로 출력하는 프로그램 작성
        int number = 987654321;
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.toOctalString(number));
        System.out.println(Integer.toHexString(number));

        //읽어온 정수의 역수를 16진 부동소수점 수로 출력하라
        System.out.println(Double.toHexString((double)1/number));
    }
}
```


```java
public class P3 {
    public static void main(String[] args) {


        //조건 연산자만을 이용해서 최대값 출력하는 프로그렘 작성.. Math.max를 이용해라
        int a = 10;
        int b = 9;
        int c = 11;

        System.out.println(Math.max(a, Math.max(b, c)));

    }
}

```

```java
public class P4 {
    public static void main(String[] args) {


        // Double 타입의 양의 최소값과 양의 최대값을 구해라

        System.out.println(Math.nextUp((double)0));
        System.out.println(Double.MAX_VALUE);

    }
}

```


```java
public class P5 {

    public static void main(String[] args) {

        //int의 최대값보다 큰 double을 int로 바꾸면 어떻게 되는가?
        double d = Integer.MAX_VALUE;
        System.out.println((int)d+1);   //overflow

    }
}
```

```java

public class P6 {
    public static void main(String[] args) {

        int number = 1000;

        BigInteger bi = BigInteger.valueOf(number);
        while(--number > 0) {
            bi = bi.multiply(BigInteger.valueOf(number));
        }

        System.out.println(bi);
    }
}
```

```java
public class P10 {
    public static void main(String[] args) {

        Random rd = new Random();
        long number = rd.nextLong();
        System.out.println(Long.toString(number, 36));

    }
}
```

```java
public class P13 {

    public static void main(String[] args) {

        //1-49의 숫자 중에서 6개를 뽑아서 정렬해 출력한다.
        ArrayList<Integer> al = new ArrayList();
        ArrayList<Integer> al2 = new ArrayList();


        for (int i = 1; i <= 49; i++) {
            al.add(i);
        }

        //6개 뽑을거임
        int counter = 6;
        int maxNumber = 49;

        Random ran = new Random();

        while (counter != 0) {

            int ranNum = ran.nextInt(maxNumber) + 1;    //1-49

            al2.add(al.get(ranNum));
            al.remove(ranNum);

            maxNumber--;
            counter--;
        }

        Collections.sort(al2);
        System.out.println(al2);
    }
}
```

```java
public class P16 {

    public static void main(String[] args) {

        //average 메소드를 개선해서 적어도 한개 이상의 파라미터를 받아도 호출되게 해라
        //jdk 1.5
        average(2, 5, 3, 3);
    }

    public static void average(int... number) {

        int sum = 0;
        for (int array : number) {
            sum += array;
        }

        System.out.println((double) sum / number.length);

    }
}
```
