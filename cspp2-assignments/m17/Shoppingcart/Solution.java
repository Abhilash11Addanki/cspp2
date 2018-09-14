import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for item.
 */
class Item {
    /**
     * product name of type String.
     */
    private String productname;
    /**
     * quantity of the product.
     */
    private int quantity;
    /**
     * price of the product.
     */
    private float price;
    /**
     * Constructs the object.
     * @param      pname      The pname
     * @param      pquantity  The pquantity
     * @param      pprice     The pprice
     */
    Item(final String pname, final int pquantity, final float pprice) {
        productname = pname;
        quantity = pquantity;
        price = pprice;
    }
    /**
     * Constructs the object.
     * @param      pname      The pname
     * @param      pquantity  The pquantity
     */
    Item(final String pname, final int pquantity) {
        productname = pname;
        quantity = pquantity;
    }
    /**
     * gets the product name.
     * @return     { description_of_the_return_value }
     */
    String getproductname() {
        return productname;
    }
    /**
     * sets the product name.
     * @param      pname  The pname
     */
    void setproductname(final String pname) {
        productname = pname;
    }
    /**
     * gets the quantity of the product.
     * @return     { description_of_the_return_value }
     */
    int getquantity() {
        return quantity;
    }
    /**
     * sets the quantity of the product.
     * @param      pquan  The pquan
     */
    void setquantity(final int pquan) {
        quantity = pquan;
    }
    /**
     * gets the price of product.
     * @return     { description_of_the_return_value }
     */
    float getprice() {
        return price;
    }
    /**
     * sets the price of product.
     * @param      pprice  The pprice
     */
    void setprice(final float pprice) {
        price = pprice;
    }
}
/**
 * Class for shopping cart.
 */
class ShoppingCart {
    /**
     * to track the discount.
     */
    private double discount = 0;
    /**
     * flag for restricting only one coupon.
     */
    private boolean flag = true;
    /**
     * cataloglist.
     */
    private ArrayList<Item> cataloglist = new ArrayList<Item>();
    /**
     * cartlist.
     */
    private ArrayList<Item> cartlist = new ArrayList<Item>();
    /**
     * Adds to catalog.
     * @param      item  The item
     */
    void addToCatalog(final Item item) {
        cataloglist.add(item);
    }
    /**
     * Adds to cart.
     * @param      item  The item
     */
    void addToCart(final Item item) {
        for (Item itemc : cataloglist) {
            if (itemc.getproductname().equals(item.getproductname())) {
                item.setprice(itemc.getprice());
                Item temp = null;
                for (Item item1 : cartlist) {
                    if (item1.getproductname().equals(item.getproductname())) {
                        item1.setquantity(item1.getquantity()
                            + item.getquantity());
                        temp = item1;
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
    /**
     * Removes product from cart.
     * @param      item  The item
     */
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
    /**
     * Shows the cart.
     */
    void showCart() {
        for (Item item : cartlist) {
            System.out.println(item.getproductname() + " " + item.getquantity());
        }
    }
    /**
     * Shows the catalog.
     */
    void showCatalog() {
        for (Item item : cataloglist) {
            System.out.println(item.getproductname() + " " + item.getquantity() + " " + item.getprice());
        }
    }
    /**
     * Gets the total amount.
     * @return     The total amount.
     */
    double getTotalAmount() {
        double sum = 0;
        for (Item item : cartlist) {
            sum += item.getquantity() * item.getprice();
        }
        return sum;
    }
    /**
     * applies the coupon.
     * @param      coupon  The coupon
     */
    void applyCoupon(final int coupon) {
        if (coupon != 10 && coupon != 20 && coupon != 30 && coupon != 50) {
            System.out.println("Invalid coupon");
            return;
        }
        if (flag) {
            double amount = getTotalAmount();
            final double denom = 100;
            discount = (amount * coupon) / denom;
            flag = false;
        }
    }
    /**
     * Gets the payable amount.
     * @return     The payable amount.
     */
    double getPayableAmount() {
        double tax = 1.15;
        return (getTotalAmount() - discount) * tax;
    }
    /**
     * prints the invoice.
     */
    void printInvoice() {
        double amount = getPayableAmount();
        System.out.println("Name" + "   " + "quantity" + "   " + "Price");
        for (Item item : cartlist) {
            System.out.println(item.getproductname() + " " + item.getquantity() + " " + item.getprice());
        }
        System.out.println("Total:" + getTotalAmount());
        System.out.println("Disc%:" + discount);
        System.out.println("Tax:" + 0.15 * (getTotalAmount() - discount));
        System.out.printf("Payable amount: %.1f\n" , amount);
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     * @param      args  The arguments
     */
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
                System.out.printf("Payable amount: %.1f\n" , sc.getPayableAmount());
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
