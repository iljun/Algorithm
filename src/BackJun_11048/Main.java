package BackJun_11048;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();
		arr = new int[N+1][M+1];
		dp = new int[N+1][M+1];

		for(int i=1; i<N+1; i++){
			for(int j=1; j<M+1; j++)
				arr[i][j] = input.nextInt();
		}

		for(int i=1; i<N+1; i++){
			for(int j=1; j<M+1; j++){
				dp[i][j] = arr[i][j]+Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
			}
		}

		System.out.println(dp[N][M]);
		input.close();
	}

}
