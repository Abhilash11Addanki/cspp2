
// Given an String, Write a java method that returns the decimal value for the given binary string.

import java.lang.Math;
import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		for(int i=0;i<n;i++){
			String s=sc.next();
			String res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	static String binaryToDecimal(String s) {
		String[] s1 = s.split("");
		int cnt = s1.length-1;
		int sum = 0;
		for (int i = 0; i < s1.length; i++){
			if (Integer.parseInt(s1[i]) == 1) {
				sum += Math.pow(2,cnt);
				cnt -= 1;
			} else {
				cnt -= 1;
			}
		}
		return Integer.toString(sum);
	}
}
