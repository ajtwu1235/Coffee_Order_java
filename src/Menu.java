
public class Menu {

	String product_name;
	int price;
	
	public Menu() {
		
	}
	
	public  Menu(String product_name,int price) {
		this.product_name = product_name;
		this.price = price;
	}
	
	public Menu(int price) {
		this.price=price;
	}
	
	public String toString() {
		
		return "상품명 :"+ product_name + "      	 가격 :" + price+"원 \n";
	}
	
	public void output() {
		System.out.println(toString());
	}
	
}

