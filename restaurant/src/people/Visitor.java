package people;

public class Visitor {
	private String name;
	private int totalPrice;

	public Visitor(String name) {
		this.name = name;
		this.totalPrice = 0;
	}

	public String getName() {
		return name;
	}

	public void addTotalPrice(int price) {
		totalPrice += price;
	}

	public void showTotalPrice() {
		System.out.println(name + "'s Total Price: " + totalPrice);
	}

}
