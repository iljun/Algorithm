package BackJun_1699;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] dp = new int[100001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		input.close();

		for(int i=1; i<N+1; i++){
			for(int j=1; j*j<=i; j++){
				if(dp[i]>dp[i-j*j] +1 || dp[i]==0)
					dp[i] = dp[i-j*j] + 1;
			}
		}

		System.out.println(dp[N]);
	}

}
