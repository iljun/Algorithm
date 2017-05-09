package BackJun_11053;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new int[N];
		dp = new int[N];

		for(int i=0; i<N; i++)
			arr[i] = input.nextInt();

		for(int i=0; i<arr.length; i++){
			dp[i] = 1;
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j] && dp[i] < dp[j] +1){
					dp[i] = dp[j] +1;
				}
			}
		}

		int result = dp[0];
		for(int i=1 ; i<dp.length; i++){
			if(result < dp[i])
				result = dp[i];
		}
		System.out.println(result);
	}

}
