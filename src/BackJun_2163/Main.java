package BackJun_2163;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();

		if(N>M){
			dp = new int[N+1];
		}else
			dp = new int[M+1];

		for(int i=2; i<dp.length; i++)
			dp[i] = i-1;

		System.out.println(dp[N]+N*dp[M]);
		input.close();
	}

}
