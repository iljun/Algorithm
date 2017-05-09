package BackJun_11052;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		dp = new int[N+1];
		arr = new int[N+1];

		for(int i=1; i<N+1; i++){
			arr[i] = input.nextInt();
		}

		for(int i=1; i<N+1; i++){
			for(int j=1; j<N+1; j++){
				if(j>=i)
					dp[j] = Math.max(dp[j], arr[i]+dp[j-i]);
			}
		}

		System.out.println(dp[N]);
		input.close();
	}

}
