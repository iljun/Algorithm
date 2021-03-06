package BackJun_2293;

import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		arr = new int[N];
		dp = new int[K+1];

		for(int i=0; i<N; i++)
			arr[i] = input.nextInt();

		dp[0]=1;
		for(int i = 0; i<N; i++){
			for(int j=arr[i]; j<=K; j++){
				dp[j] += dp[j-arr[i]];
			}
		}
		System.out.println(dp[K]);
		input.close();
	}

}
