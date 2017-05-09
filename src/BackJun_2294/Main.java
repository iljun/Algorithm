package BackJun_2294;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.Segment;
public class Main {
	static int N;
	static int K;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		arr = new int[N];
		dp = new int[K+1];

		for(int i=0; i<arr.length; i++)
			arr[i] = input.nextInt();
		Arrays.fill(dp, 10001);
		dp[0]=0;

		for(int i=0; i<N; i++){
			for(int j=arr[i]; j<=K; j++){
				dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
			}
		}
		//System.out.println(Arrays.toString(dp));

		if(dp[K]==10001)
			System.out.println(-1);
		else
			System.out.println(dp[K]);
		input.close();
		Segment f = new Segment();

	}

}
