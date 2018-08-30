import java.util.Scanner;
class FirstLast6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(firstLast6(arr));
	}
	static boolean firstLast6(int[] arr) {
		if (arr[0] == 6 || arr[arr.length-1] == 6) {
			return true;
		}
		else{
			return false;
		}
	}
}