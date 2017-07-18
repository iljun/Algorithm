package BackJun_8895;

import java.util.Scanner;

public class Main {
	static int T;
	static long[][][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		T = input.nextInt();
		dp = new long[21][21][21];
		dp[1][1][1] = 1;

		for(int n=2; n<21; n++){
			for(int l=1 ;l<21; l++){
				for(int r =1; r<21; r++){
					dp[n][l][r] = dp[n-1][l][r]*(n-2) + dp[n-1][l-1][r] + dp[n-1][l][r-1];
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		for(int i=0; i<T; i++){
			int n = input.nextInt();
			int l = input.nextInt();
			int r = input.nextInt();
			builder.append(dp[n][l][r]).append("\n");
		}
		input.close();

		System.out.println(builder);

	}

}
