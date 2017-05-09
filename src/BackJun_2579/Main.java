package BackJun_2579;

import java.util.Scanner;

public class Main {
	static int[] list;
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		list = new int[N];
		dp = new int[N];

		for(int i=0; i<N; i++){
			list[i]=input.nextInt();
		}

		dp[0]=list[0];

		for(int i=1; i<3; i++){
			if(i==1)
				dp[i] = Math.max(dp[i-1] + list[i], list[i]);
			else
				dp[i] = Math.max(dp[i-1] + list[i], dp[i-2] + list[i]);
		}

		for(int i=3; i<N; i++){
			dp[i] = Math.max(dp[i-2] + list[i], dp[i-3] + list[i] + list[i-1]);
		}

		System.out.println(dp[N-1]);
	}

}