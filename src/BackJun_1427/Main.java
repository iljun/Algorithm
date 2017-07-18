package BackJun_1427;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String a = input.next();
		input.close();
		char[] arr = a.toCharArray();
		int[] arr2 = new int[arr.length];

		for(int i=0; i<arr2.length; i++){
			arr2[i]=arr[i]-48;
		}

		Arrays.sort(arr2);

		for(int i=0; i<arr2.length; i++)
			System.out.print(arr2[arr2.length-i-1]);
	}

}
