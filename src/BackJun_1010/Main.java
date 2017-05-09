package BackJun_1010;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int num = input.nextInt();
		StringBuilder builder = new StringBuilder();

		for(int i=0; i<num; i++){
			N = input.nextInt();
			M = input.nextInt();
			dp = new int[N+1][M+1];

			for(int j=1; j<=M; j++)
				dp[1][j] = j;

			for(int j=2; j<=N; j++){
				for(int k=j;k<=M;k++){
					for(int l=k;l>=j;l--){
						dp[j][k]+=dp[j-1][l-1];
			        }
			    }
			}
			builder.append(dp[N][M]).append("\n");
		}

		System.out.println(builder);
		input.close();
	}

}
