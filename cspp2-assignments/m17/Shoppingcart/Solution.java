import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
class Item {
	private String productname;
	private int quantity;
	private float price;
	Item (final String pname, final int pquantity, final float pprice) {
		productname = pname;
		quantity = pquantity;
		price = pprice;
	}
	Item (final String pname, final int pquantity) {
		productname = pname;
		quantity = pquantity;
	}
	String getproductname() {
		return productname;
	}
	void setproductname(final String pname) {
		productname = pname;
	}
	int getquantity() {
		return quantity;
	}
	void setquantity(final int pquan) {
		quantity = pquan;
	}
	float getprice() {
		return price;
	}
	void setprice(final float pprice) {
		price = pprice;
	}
}
class ShoppingCart {
	double sum = 0;
	double discount = 0;
	private ArrayList<Item> cataloglist = new ArrayList<Item>();
	private ArrayList<Item> cartlist = new ArrayList<Item>();
	void addToCatalog(final Item item) {
		cataloglist.add(item);
	}
	void addToCart(final Item item) {
		for (Item itemc : cataloglist) {
			if (itemc.getproductname().equals(item.getproductname())) {
				cartlist.add(item);
			}
		}
	}
	void removeFromCart(final Item item) {
		for (Item itemc : cartlist) {
			if (itemc.getproductname().equals(item.getproductname())) {
				if (itemc.getquantity() == item.getquantity()) {
					cartlist.remove(item);
				} else {
					int newprice;
					newprice = itemc.getquantity() - item.getquantity();
					itemc.setquantity(newprice);
				}
			}
		}
	}
	void showCart() {
		for (Item item : cartlist) {
			System.out.println(item.getproductname() + " " + item.getquantity());
		}
	}
	void showCatalog() {
		for (Item item : cataloglist) {
			System.out.println(item.getproductname() + " " + item.getquantity() + " " + item.getprice());
		}
	}
	double getTotalAmount() {
		sum = 0;
		for (Item item : cartlist) {
			for (Item item1 : cataloglist) {
				if (item.getproductname().equals(item1.getproductname())) {
					sum += item1.getprice() * item.getquantity();
				}
			}
		}
		return sum;
	}
	double getPayableAmount() {
		sum = 0;
		for (Item item : cartlist) {
			for (Item item1 : cataloglist) {
				if (item.getproductname().equals(item1.getproductname())) {
					sum += item1.getprice() * item.getquantity();
				}
			}
		}
		return (sum + 0.15 * sum + discount);
	}
	void applyCoupon(String coupon) {
		if (coupon.equals("IND10")) {
			discount = (10 / 100) * sum;
		} else if (coupon.equals("IND20")) {
			discount = (20 / 100) * sum;
		} else if (coupon.equals("IND30")) {
			discount = (30 / 100) * sum;
		} else if (coupon.equals("IND50")) {
			discount = (50 / 100) * sum;
		}
	}
	void print() {
		double amount = getPayableAmount();
		System.out.println("Name" + "   " + "quantity" + "   " + "Price");
		showCatalog();
		System.out.println("Total:" + sum);
		System.out.println("Disc%:" + discount);
		System.out.println("Tax:" + 0.15 * sum);
		System.out.println("Payable amount: " + amount);
	}
}
class Solution {
	public static void main(final String[] args) {
		ShoppingCart sc = new ShoppingCart();
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testCases; i++) {
			String[] tokens = scan.nextLine().
			                  replace("[", "").replace("]", "").split(",");
			switch (tokens[0]) {
			case "Item":
			final int three = 3;
				sc.addToCatalog(new Item(tokens[1], Integer.parseInt(tokens[2]), Float.valueOf(tokens[three])));
				break;

			case "add":
				sc.addToCart(new Item(tokens[1], Integer.parseInt(tokens[2])));
				break;

			case "catalog":
				sc.showCatalog();
				break;

			case "show":
				sc.showCart();
				break;

			case "totalAmount":
				System.out.println("totalAmount: " + sc.getTotalAmount());
				break;
			case "remove":
				sc.removeFromCart(new Item(tokens[1], Integer.parseInt(tokens[2])));
				break;
			case "coupon":
				sc.applyCoupon(tokens[1]);
				break;
			case "payableAmount":
				System.out.println("Payable amount: " + sc.getPayableAmount());
				break;
			case "print":
				sc.print();
				break;
			default:
				break;
			}
		}
	}
}
