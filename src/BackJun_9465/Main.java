package BackJun_9465;

import java.util.Scanner;

public class Main {
	static int T;
	static int N;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();

		T = input.nextInt();
		for(int k=0; k<T; k++){
			N = input.nextInt();
			arr = new int[3][N+1];
			dp = new int[3][N+1];

			for(int i=1; i<3; i++){
				for(int j=1; j<N+1; j++){
					arr[i][j] = input.nextInt();
				}
			}

			dp[0][0] = 0;
			dp[1][0] = arr[1][0];
			dp[2][0] = arr[2][0];

			for(int i=1; i<N+1; i++){
				dp[0][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));//안땐경우
				dp[1][i] = arr[1][i] + Math.max(dp[0][i-1],dp[2][i-1]);//위에 스티커
				dp[2][i] = arr[2][i] + Math.max(dp[0][i-1], dp[1][i-1]);//아래 스티커
			}

			builder.append(Math.max(dp[2][N],Math.max(dp[0][N], dp[1][N]))).append("\n");
		}
		System.out.println(builder.toString());
		input.close();
	}

}