package BackJun_1890;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static long[][] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new int[N][N];
		dp = new long[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				arr[i][j] = input.nextInt();
		}
		input.close();

		dp[0][0]=1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==0 && j==0)
					continue;/*
				for (int k = 1; k <= arr[i][j] && i + k < N; k++)
					dp[i + k][j]++;
				for (int k = 1; k <= arr[i][j] && j + k < N; k++)
					dp[i][j + k]++;
					*/
				for (int k = 0; k < j; k++)//방법1
	                if (k + arr[i][k] == j)
	                    dp[i][j] += dp[i][k];
	            for (int k = 0; k < i; k++)//방법2
	                if (k + arr[k][j] == i)
	                    dp[i][j] += dp[k][j];

			}
		}
		System.out.println(dp[N-1][N-1]);
	}

}
