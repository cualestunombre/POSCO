package prob5;

import java.util.List;

public class Prob5 {

	public static List<Character> chars = List.of('3','6','9');
	public static void main(String[] args) {
		for (int i = 0 ; i <= 99 ; i++) {
			
			String s = Integer.toString(i);
			
			int count = 0;
			for (int j = 0 ; j< s.length() ; j++) {
				if (chars.contains(s.charAt(j))) {
					count += 1;
				}
			}
			if (count >= 1) {
				System.out.print(s+" ");
				for(int k = 0 ; k < count ; k++) {
					System.out.print("짝");
				}
				System.out.println("");
				
			}
			
		}
	}
}
