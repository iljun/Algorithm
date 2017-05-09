package BackJun_9084;

import java.util.Scanner;
public class Main {
	static int N;
	static int K;
	static int M;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N=input.nextInt();
		StringBuilder builder = new StringBuilder();

		for(int i=0; i<N; i++){
			K=input.nextInt();
			arr = new int[K];
			for(int j=0; j<arr.length; j++){
				arr[j]=input.nextInt();
			}
			M = input.nextInt();
			dp = new int[M+1];
			dp[0]=1;
			for(int k=0; k<K; k++){
				for(int l=arr[k]; l<M+1; l++){
					dp[l] += dp[l-arr[k]];
				}
			}
			builder.append(dp[M]).append("\n");
		}
		System.out.println(builder.toString());
		input.close();
	}

}
