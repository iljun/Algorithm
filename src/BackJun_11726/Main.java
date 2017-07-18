package BackJun_11726;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();

		input.close();

		dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<N+1; i++)
			dp[i]=(dp[i-1]+dp[i-2])%10007;

		System.out.println(dp[N]);
	}

}
