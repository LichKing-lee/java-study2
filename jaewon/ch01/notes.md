##2018년 07월 08일 (53페이지까지 진행함)

같이 책 보면서.. 진행해서 책이 필수
이해안가면 질문

깃허브 https://github.com/LichKing-lee/java-study2
연습문제는 마음대로 풀면 됩니다.

메소드 안에서 if, else문으로 하지말고
바로 boolean으로 return




면접 팁을 많이 알려주시는데, 잘 정리해놓아야 겠다.
(생각보다 8개의 primitive data types 설명하지 못하는 개발자들이 많다.)

md 작성법을 다시 봐야겠다

------------------------------------
##2018년 7월 15일 (1장 끝까지 진행)
-- 면접관으로 들어왔는데 접근제어자를 잘 대답 못했...

-- github에 대해서
git fetch(변경사항 확인만) / git pull(변경사항 가져오기)
스테이징과 언 스테이징 (git add or git add .)
    
git log (로그 확인)
    
revert : 커밋한거 취소되서, 나중에 동료들이 fetch하고 pull해야함
reset : 잘못된 커밋들은 그냥 삭제 해버리는 거
    근데 서버에는 파일이 있어서 push가 안되는데...
    git push origin master --force로 해서 강제로 넣어버려서 (서버도)
    (다른 사람들은 골치아파져서 reset은 왠만하면 하지마랑...)
    git revert 깃 코드
    vi에서 :wq하고.. git push로 마무리!

--java
    equals에 대해서
    단순 문자열 비교는 아니고 객체 비교
    equals는 null비교때문에 리터럴 문자열을 앞에 두는 것이 좋다.
    null에는 equals 없
    
    
i의 값에 따라서 null이 될수도 있기 때문에
.toString()보다는 String.valueOf(i)를 쓰는게 좋다.
```java
i.toString();
String.valueOf(i); //(null safe)
(String) i;
```

가변 객체와 불변 객체에 대해서 (setter)
intellij 탭 보는 플러그인? (해결)

RandomAccess (Marker 가능하다는 이야기?)

캐쉬가 되어 있는 Integer 범위는 true를 반환하지만
캐시가 되어 있지 않은 범위를 비교 연산자로 비교하면 false
```java
Integer i1 = 50; //i1 == i2 true
Integer i2 = 50;
Integer i3 = 250;   //i3 == i4 false
Integer i4 = 250;
```

LinkedList 와 for문
(의도와 다르게 2중 for문으로 작동한다는 이야기)
