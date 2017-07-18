package BackJun_1328;

import java.util.Scanner;

public class Main {
	static int N;
	static int L;
	static int R;
	static long[][][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		L = input.nextInt();
		R = input.nextInt();

		input.close();

		dp = new long[101][101][101];
		dp[1][1][1] = 1;

		for(int n = 2; n<=N; n++){
			for(int l=1; l<=L; l++){
				for(int r=1; r<=R; r++){
					dp[n][l][r] = (dp[n-1][l][r]*(n-2) + dp[n-1][l-1][r] + dp[n-1][l][r-1]);
					dp[n][l][r] %= 1000000007;
				}
			}
		}

		System.out.println(dp[N][L][R]);
	}

}
