package BackJun_2156;

import java.util.Scanner;

public class Main {
	static int[] list;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		list = new int[N+1];
		dp = new int[N+1];

		for(int i=1; i<=N; i++){
			list[i] = input.nextInt();
		}

		dp[0] = 0;
		dp[1] = list[1];
		dp[2] = dp[1] + list[2];
		for(int i=3; i<=N; i++){
			dp[i] = Math.max(Math.max(dp[i-3] + list[i-1] + list[i], dp[i-2] + list[i]),dp[i-1]);
		}

		System.out.println(dp[N]);
	}

}
