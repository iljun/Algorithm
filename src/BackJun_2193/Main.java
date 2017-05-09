package BackJun_2193;

import java.util.Scanner;

public class Main {
	static int[] dp;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		dp = new int[N+1];

		dp[1] = 1;
		dp[2] = 1;

		for(int i=3; i<=N; i++){
			dp[i]=dp[i-1]+dp[i-2];
		}

		System.out.println(dp[N]);
	}

}
