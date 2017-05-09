package BackJun_1965;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] dp;
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		dp = new int[N + 1];
		arr = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			arr[i] = input.nextInt();
		}

		for (int i = 1; i < N + 1; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (arr[i] > arr[j]) {
					if (dp[j] + 1 > dp[i])
						dp[i] = dp[j] + 1;
				}

			}
		}

		int max = dp[1];

		for (int i = 2; i < N + 1; i++) {
			if (max < dp[i])
				max = dp[i];
		}

		System.out.println(max);
		input.close();
	}

}
