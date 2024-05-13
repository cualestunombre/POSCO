
package chapter03;

public class Student extends Person{
	
	public Student() {
		
		// 부모 클래스의 생성자가 가장 먼저 위치해야한다
		// 넣지 않아도 기본생성자를 자동으로 넣어 주지만 부모 클래스의 기본 생성자가 호출이 불가능하면 안된다
		super();
		System.out.println("Student 클래스의 생성자가 호출");
		
	}
	
	
}
