
import java.awt.Image;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CoffeeSystem {

	static Vector <Menu> hot_drink = new Vector<Menu>();
	static Vector <Menu> ice_drink = new Vector<Menu>();
	static Vector <Menu> ade_drink = new Vector<Menu>();
	static Vector <Menu> deasert = new Vector<Menu>();
	static Vector <Menu> order = new Vector<Menu>();
	static Vector<Integer> price = new Vector<Integer>();
	

	
	static Menu new_Hot_Drink(String product_name,int price) {
		
		Menu new_Hot_Drink = new Menu(product_name,price);
		CoffeeSystem.addToHotDrink(new_Hot_Drink);	
		return new_Hot_Drink;
	}
	
	static Menu new_Ice_Drink(String product_name,int price) {
		
		Menu new_Ice_Drink = new Menu(product_name,price);
		CoffeeSystem.addToIceDrink(new_Ice_Drink);				
		return new_Ice_Drink;
		
	}
	
	static Menu new_Ade_Drink(String product_name,int price) {
		
		Menu new_Ade_Drink = new Menu(product_name,price);
		CoffeeSystem.addToAdeDrink(new_Ade_Drink);				
		return new_Ade_Drink;
		
	}
	
	static Menu new_Deasert(String product_name,int price) {
		
		Menu new_Deasert = new Menu(product_name,price);
		CoffeeSystem.addToDeasert(new_Deasert);				
		return new_Deasert;
		
	}
	static Integer new_Price(int price) {
		
		Integer new_Price = new Integer(price);
		CoffeeSystem.addToPrice(new_Price);	
		return new_Price;
	}
	
	static  String total_Price(int sum) {
		
		sum=0;
		int m;
		for(int i=0; i<CoffeeSystem.getNumPrices(); i++) {			
			m=CoffeeSystem.getPrice(i);
			sum = sum+m;
	}
		return "총 가격 :"+sum+"원";
	}
	 // 이미지 크기조절하기!
	 static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	       Image img = icon.getImage();  
	       Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	       return new ImageIcon(resizedImage);
	}
	
	 
	 
	private static void addToPrice(Integer new_Price) {
		price.add(new_Price);
		
	}

	private static void addToDeasert(Menu new_Deasert) {
		
		deasert.add(new_Deasert);		
	}

	private static void addToAdeDrink(Menu new_Ade_Drink) {
		ade_drink.add(new_Ade_Drink);
		
	}

	private static void addToIceDrink(Menu new_Ice_Drink) {
		ice_drink.add(new_Ice_Drink);
	}

	
	
	private static void addToHotDrink(Menu new_Hot_Drink) {
		hot_drink.add(new_Hot_Drink);
		
	}
	
	static void setupMenu() {
		CoffeeSystem.new_Hot_Drink("(Hot)아메리카노", 1500);
		CoffeeSystem.new_Hot_Drink("(Hot)카푸치노", 2500);
		CoffeeSystem.new_Ice_Drink("(ICE)아메리카노", 2000);
		CoffeeSystem.new_Ice_Drink("(ICE)카페라떼", 2500);
		CoffeeSystem.new_Ade_Drink("(ICE)레몬에이드", 3000);
		CoffeeSystem.new_Ade_Drink("자몽에이드", 3000);
		CoffeeSystem.new_Deasert("초코케이크 (1조각)", 3000);
		CoffeeSystem.new_Deasert("딸기케이크 (1조각)", 3500);		
	}
		
	@SuppressWarnings("unused")
	private static void new_Order_HotDrink(Menu new_Hot_Drink) {
		order.add(new_Hot_Drink);
	}
	

	static String Customer_order() {
		Menu m;
		
		System.out.println("\n--모든 주문 리스트 --");
				
		for(int i=0; i<CoffeeSystem.getNumOrders(); i++) {
			m=CoffeeSystem.getOrder(i);
			System.out.print(i+1+". ");
			m.output();		
			
		}
		return null;
	
	}
	static Menu getOrder(int witch) {
			
		return order.elementAt(witch);
	}
	static int getNumOrders() {

		return order.size();
	}
	static int getNumPrices() {
		return price.size();
	}
	static Integer getPrice(int witch) {
		return price.elementAt(witch);
	}
	static Integer get_Price(int witch) {
		return price.get(witch);
	}
	
	public static void main(String[] args) {//Test
	

		Customer_order();
		price.get(1);
	}

	
}

 