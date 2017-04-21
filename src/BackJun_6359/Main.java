package BackJun_6359;

import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();

		N = input.nextInt();
		for(int i=0; i<N; i++){
			int x = input.nextInt();
			boolean[] dp = new boolean[x+1];
			for(int k=2; k<=x; k++){
				int count=k;
				while(count<=x){
					if(dp[count]==false)
						dp[count]=true;
					else
						dp[count]=false;
					count+=k;
				}
			}
			int q=0;
			for(int k=1; k<dp.length; k++){
				if(dp[k]==false)
					q++;
			}
			builder.append(q).append("\n");
		}
		System.out.println(builder.toString());

	}
}
