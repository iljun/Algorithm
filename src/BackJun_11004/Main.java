package BackJun_11004;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		arr = new int[N];

		for(int i=0; i<N; i++)
			arr[i] = input.nextInt();

		Arrays.sort(arr);

		System.out.println(arr[K-1]);
		input.close();
	}

}
