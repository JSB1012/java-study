package chapter03;

import mypackage.Goods2;

public class EventGoods2 extends Goods2 {
	private float discountRate = 0.5f;

	public int getDiscountPrice() {
		//protected는 자식에서 접근이 가능하다.
		int discountPrice = (int) discountRate * price; // 소수점이 짤릴 위험이 있을 경우 빨간줄 int discountPrice = discountRate * price 명시적으로  (int)
	
		return discountPrice;
	}

}
