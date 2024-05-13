package chapter03;

public class StudentTest02 {
	public static void main(String[] args) {
		Student s1 = new Student();
		
		Person p1 = s1;
		// 업캐스팅은 암시적으로 수행
		
		s1 = (Student)p1;
	}

}
