### 참석인원
- 출석표 참조

### 장소 및 비용
- 서현 토즈, 48,000

## 진행내용
### git 처음 시작
- 처음 레파지토리를 만들고 사용할때는 레파지토리에 있는 디렉토리를 clone 받아 시작하거나
- 로컬 디렉토리를 git init으로 초기화 한 이후에 remote에 push 해서 사용할 수 있음

### branch
- branch 를 분리해 다른 동료들과 독립된 공간에서 혼자 작업할 수 있음
- github 에서 제공하는 Pull Request를 이용해 독립 브랜치를 merge 하며 코드리뷰를 할 수 있음

01. finalize
```
public class Test {
	public static void main(String[] args) {
		Person p  = new Person("",30);
		// 다른 객체로 바꿔야 위에 Person 객체가 수거될 수 있음
		p = new Person("",20);

		System.gc();
	}

	static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public void finalize() {
			System.out.println("finalize");
		}
	}
}
```

02. reference
```
public class Test {
	public static void main(String[] args) {
		int n = 5;
		change(n);

		System.out.println(n);

		Person person = new Person("", 5);
		change(person);

		System.out.println(person.age);
	}

	private static void change(int n) {
		n = 50;
	}

	private static void change(Person person) {
		person = new Person("", 30);
	}

	static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}
}
```

03. factory method
```
public class Test {
	public static void main(String[] args) {
		Person person = Person.of("", 30);
	}

	static class Person {
		private String name;
		private int age;

		private Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public static Person of(String name, int age) {
			return new Person(name, age);
		}
	}
}
```
