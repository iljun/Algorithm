package BackJun_2193;

import java.util.Scanner;

public class Main {
	static long[][] dp;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		dp = new long[N+1][2];

		input.close();

		dp[1][1]=1;

		for(int i=2; i<N+1; i++){
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
		    dp[i][1] = dp[i-1][0];
		}

		System.out.println(dp[N][1]+dp[N][0]);

	}

}