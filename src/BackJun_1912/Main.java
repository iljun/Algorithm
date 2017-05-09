package BackJun_1912;

import java.util.Scanner;

public class Main {
	static long N;
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextLong();
		arr = new int[(int) (N+1)];
		dp = new int[(int) (N+1)];

		for(int i=1; i<N+1; i++)
			arr[i] = input.nextInt();


		for(int i=1; i<N+1; i++){
			for(int j=i; j<N+1; j++)
				dp[j] = Math.max(arr[i], dp[j-1]+arr[i]);
		}
		int max=dp[1];
		for(int i=2; i<N+1; i++){
			if(dp[i]>max)
				max=dp[i];
		}
		System.out.println(max);
		input.close();
	}

}
