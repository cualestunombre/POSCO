package chapter03;

public class Goods {
	
	private String name;
	private int price;
	private int countStock;
	private int countSold;

	public static int countOfGoods = 0;
	
	public Goods() {
		this("",0,0,0);
		
		
	}
	
	public Goods(String name, int price,int countStock, int countSold) {
		this.name = name;
		this.price = price;
		this.countSold = countSold;
		this.countStock = countStock;
		
		
		countOfGoods += 1;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		
		if (price < 0) {
			price = 0;
		}
		/*
		 *  정보 보호 로직
		 */
		
		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	public int calcDiscountPrice(float percentage) {
		return (int) (price - price*percentage);
	}

	public void showInfo() {
		
		System.out.println("상품이름: " + name + ", 가격: " + Integer.toString(price) + ", 재고개수: " +
				Integer.toString(countStock) + ", 팔린 개수: " + Integer.toString(countSold)
				);		
	}

}
