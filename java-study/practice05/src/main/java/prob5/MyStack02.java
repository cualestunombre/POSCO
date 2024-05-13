package prob5;

import java.lang.reflect.Array;
import java.util.Arrays;
/*
 * 올바른 제네릭 사용법에 대한 가이드 -> 제네릭은 런타임에 타입관련 오류를 컴파일 타임에 잡기 위해 사용하는 것
 * ?와 같은 wild카드는 함수를 위해 사용하는 것
 */ 
public class MyStack02<T> {
 
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyStack02(int size) {
        array = (T[]) new Object[size];
        size = 0;
    }
    
    @SuppressWarnings("unchecked")
	public MyStack02(Class<? extends T> klass,int size) {
    	array = (T[]) Array.newInstance(klass, size);
    	size = 0;
  
    }

    public void push(T element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T pop() throws MyStackException {
        if (isEmpty()) {
            throw new MyStackException("Stack is empty");
        }
        return array[--size];
    }

    private void resize() {
        int newSize = array.length * 2;
        array = Arrays.copyOf(array, newSize);
    }
}

class MyStack03<T,V> extends MyStack02<T> {

	public MyStack03(Class<? extends T> klass, int size) {
		super(klass, size);
	
	}
	
	public MyStack03(int size) {
		super(size);
	
	}

	public static void test() {
		MyStack03<Integer,String> stack = new MyStack03<>(5);
		// 오류 발생 MyStack02<Number> p1 = stack;
		MyStack03<? extends Number ,String> p2 = stack;
        // 오류발생 MyStack03<? extends String,String> p3 = stack; 
		
	}
}
