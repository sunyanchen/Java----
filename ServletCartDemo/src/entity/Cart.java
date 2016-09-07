package entity;

import java.util.HashMap;
import java.util.HashSet;

public class Cart {
	private HashMap<Items, Integer> goods;
	private double totalPrice;
	public Cart(){
		goods = new HashMap<>();
		totalPrice = 0.0;
	}
	public HashMap<Items, Integer> getGoods() {
		return goods;
	}
	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
