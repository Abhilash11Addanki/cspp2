import java.util.Scanner;
class Average{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];
		int sum = 0;
		System.out.println("Enter the elements:");
		for (int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++){
			sum += arr[i];
		}
		System.out.println("The average of elements of array are:"+sum/n);
	}
}