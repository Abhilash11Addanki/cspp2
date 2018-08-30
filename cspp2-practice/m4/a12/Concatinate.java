import java.util.Scanner;
class Concatinate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(helloName(s));
	}
	static String helloName(String s) {
		return "Hello ".concat(s+"!");
	}
}