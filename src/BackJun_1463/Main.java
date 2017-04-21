package BackJun_1463;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int[] dp = new int[x+1];
		dp[1]=0;
		for(int i=2; i<=x; i++){
			int min=dp[i-1];
			if(i%3==0){
				min=Math.min(min, dp[i/3]);
			}else if(i%2==0){
				min=Math.min(min, dp[i/2]);
			}
			dp[i]=min+1;
		}
		System.out.println(dp[x]);

	}

}
