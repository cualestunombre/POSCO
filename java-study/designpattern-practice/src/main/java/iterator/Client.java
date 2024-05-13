package iterator;

public class Client {
	
	public static void main(String[] args) {
		
		Aggregate<String> fruits = new AggregateImpl<>(new String[] {"Mango","Banana","Pineapple"});
		Iterator<String> it = fruits.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
