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
	double discount = 0;
	boolean flag = true;
	private ArrayList<Item> cataloglist = new ArrayList<Item>();
	private ArrayList<Item> cartlist = new ArrayList<Item>();
	void addToCatalog(final Item item) {
		cataloglist.add(item);
	}
	void addToCart(final Item item) {
		for (Item itemc : cataloglist) {
			if (itemc.getproductname().equals(item.getproductname())) {
				item.setprice(itemc.getprice());
				Item temp = null;
				for (Item j : cartlist) {
					if (j.getproductname().equals(item.getproductname())) {
						j.setquantity(j.getquantity() + item.getquantity());
						temp = j;
						break;
					}
				}
				if (temp == null) {
					cartlist.add(item);
				}
				break;
			}
		}
	}
	void removeFromCart(final Item item) {
		for (Item itemc : cartlist) {
			if (itemc.getproductname().equals(item.getproductname())) {
				itemc.setquantity(itemc.getquantity() - item.getquantity());
				if (itemc.getquantity() == 0) {
					cartlist.remove(itemc);
				}
				break;
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
		double sum = 0;
		for (Item item : cartlist) {
			sum += item.getquantity() * item.getprice();
		}
		return sum;
	}
	void applyCoupon(int coupon) {
		if (coupon != 10 && coupon != 20 && coupon != 30 && coupon != 50) {
			System.out.println("Invalid coupon");
		}
		if (flag) {
			double amount = getTotalAmount();
			final double denom = 100;
			discount = (amount * coupon) / denom;
			flag = false;
		}
	}
	double getPayableAmount() {
		double tax = 1.15;
		return (getTotalAmount() - discount) * tax;
	}
	void printInvoice() {
		double amount = getPayableAmount();
		System.out.println("Name" + "   " + "quantity" + "   " + "Price");
		for (Item item : cartlist) {
			System.out.println(item.getproductname() + " " + item.getquantity() + " " + item.getprice());
		}
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + discount);
		System.out.println("Tax:" + 0.15 * (getTotalAmount() - discount));
		System.out.println("Payable amount: %.1f\n" + amount);
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
			String[] check = tokens[0].split(" ");
			switch (check[0]) {
			case "Item":
				sc.addToCatalog(new Item(check[1], Integer.parseInt(tokens[1]), Float.valueOf(tokens[2])));
				break;

			case "add":
				sc.addToCart(new Item(check[1], Integer.parseInt(tokens[1])));
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
				sc.removeFromCart(new Item(check[1], Integer.parseInt(tokens[1])));
				break;
			case "coupon":
				sc.applyCoupon(Integer.parseInt(check[1].replace("IND", "")));
				break;
			case "payableAmount":
				System.out.println("Payable amount: " + sc.getPayableAmount());
				break;
			case "print":
				sc.printInvoice();
				break;
			default:
				break;
			}
		}
	}
}
