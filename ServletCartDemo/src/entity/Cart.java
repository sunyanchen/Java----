package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	
	//�����Ʒ
	public boolean addGoodsInCart(Items item, int number){
		if (goods.containsKey(item)) {
			goods.put(item, goods.get(item)+number);
		}
		else {
			goods.put(item, number);
		}
		calTotalPrice();
		return true;
	}
	
	//ɾ����Ʒ
	public boolean delGoodsFromCart(Items item) {
		goods.remove(item);
		calTotalPrice();
		return true;
	}
	
	//������Ʒ���ܼ۸�
	public double calTotalPrice() {
		double sum = 0.0;
		Set<Items> keys = goods.keySet();
		Iterator<Items> ite = keys.iterator();
		while (ite.hasNext()) {
			Items i = ite.next();
			sum += i.getPrice() * goods.get(i);
		}
		this.setTotalPrice(sum);
		return this.totalPrice;
	}
	
public static void main(String[] args) {
		
		//�ȴ���������Ʒ����
		Items i1 = new Items(1,"��������Ь","����",200,500,"001.jpg");
		Items i2 = new Items(2,"�����˶�Ь","����",300,500,"002.jpg");
		Items i3 = new Items(1,"��������Ь","����",200,500,"001.jpg");
		
		Cart c = new Cart();
		c.addGoodsInCart(i1, 1);
		c.addGoodsInCart(i2, 2);
		//�ٴι�����������Ь������3˫
		c.addGoodsInCart(i3, 3);
		
		
		//����������Ʒ�ļ���
		Set<Map.Entry<Items, Integer>> items= c.getGoods().entrySet();
		for(Map.Entry<Items, Integer> obj:items)
		{
			System.out.println(obj);
		}
		
		
		System.out.println("���ﳵ���ܽ�"+c.getTotalPrice());
		
	}
	
}
