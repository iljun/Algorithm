package BackJun_1660;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();

		arr = new int[N + 1];
		dp = new int[300001];

		arr[1] = 1;

		for (int i = 2; i < N + 1; i++)
			arr[i] = arr[i - 1] + i;

		for (int i = 1; i < N + 1; i++)
			arr[i] = arr[i - 1] + arr[i];

		Arrays.fill(dp, 300001);

		dp[0] =0 ;

		for (int  i = 0; i < N + 1; i++) {
			dp[arr[i]] = 1;
			for (int j = arr[i]; j < N + 1; j++) {
				dp[j] = dp[j] > dp[j - arr[i]] + 1 ? dp[j - arr[i]] + 1 : dp[j];
			}
		}
		System.out.println(dp[N]);
	}
}
