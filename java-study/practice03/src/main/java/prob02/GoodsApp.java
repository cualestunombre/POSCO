package prob02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		
		for(int i = 0 ; i < COUNT_GOODS ; i++) {
			String[] items  =
					scanner.nextLine().split(" ");
			
			String name = items[0];
			int price = Integer.parseInt(items[1]);
			int stock = Integer.parseInt(items[2]);
			
			goods[i] = new Goods(price, name, stock);
			
			
		}
		
		
		for(int i = 0 ; i < COUNT_GOODS ; i++) {
			System.out.println(goods[i].getName()+"(가격:"+goods[i].getPrice()+")원이 "+goods[i].getStock()+"개 입고 되었습니다.");
		}
		

		
		
		scanner.close();
	}
	
	public static class Goods{
		
		private int price;
		private String name;
		private int stock;
		
		public Goods(int price, String name, int stock) {
			this.price = price;
			this.name = name;
			this.stock = stock;
		}
		
		public int getPrice() {
			return price;
		}
		
		public int getStock() {
			return stock;
		}
		
		public String getName() {
			return name;
		}
	}
}


