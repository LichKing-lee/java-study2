P1

```
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

P5

```
public class P5 {

    public static void main(String[] args) {

        //int의 최대값보다 큰 double을 int로 바꾸면 어떻게 되는가?
        double d = Integer.MAX_VALUE;
        System.out.println((int)d+1);   //overflow

    }
}
```


