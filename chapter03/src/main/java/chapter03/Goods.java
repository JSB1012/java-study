package chapter03;

public class Goods {
	
	public static int countOfGoods;		//main 앞에 static 붙이는 이유?
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() {
		Goods.countOfGoods = countOfGoods + 1;
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
		// 데이터 보호
		if(price < 0) {
			price = 0;
		}
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
	}					//private 참조 가능하게 getter/setter

	public void showInfo() {
		System.out.println(
				"name:" + name + ",price:" + price + ", countStock:" + countStock + ", countSold:" + countSold);

	}

	public int calcDiscountPrice(double discountRate) {
		return (int)(discountRate * price);
	}

}
