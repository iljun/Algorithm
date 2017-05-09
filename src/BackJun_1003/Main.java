package BackJun_1003;

import java.util.Scanner;

public class Main {
	static int[][] dp;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		dp = new int[N][2];

		for(int i=0; i<N; i++){
			fibonacci(i,input.nextInt());
		}

		for(int i=0; i<N; i++){
			System.out.println(dp[i][0] + " " + dp[i][1]);
		}
	}

	public static int fibonacci(int i, int n){
		if(n==0){
			dp[i][0]++;
			return 0;
		}else if(n==1){
			dp[i][1]++;
			return 1;
		}else{
			return fibonacci(i, n-1) + fibonacci(i, n-2);
		}
	}
}
