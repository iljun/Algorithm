package BackJun_1904;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		dp = new int[N+1];

		input.close();

		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<N+1; i++)
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;

		System.out.println(dp[N]);
	}

}
