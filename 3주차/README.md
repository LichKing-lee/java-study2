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
