package BackJun_3067;

import java.util.Scanner;

public class Main {
	static int T;
	static int N;
	static int M;
	static int[] dp;
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();

		T = input.nextInt();
		for (int i = 0; i < T; i++) {
			N = input.nextInt();
			arr = new int[N + 1];
			for (int j = 1; j < arr.length; j++)
				arr[j] = input.nextInt();

			M = input.nextInt();
			dp = new int[M + 1];
			dp[0] = 1;
			for (int j = 1; j < N + 1; j++) {
				for (int k = arr[j]; k <= M; k++) {
					dp[k] += dp[k - arr[j]];
				}

			}
			builder.append(dp[M]).append("\n");
		}

		System.out.println(builder.toString());
		input.close();
	}

}
