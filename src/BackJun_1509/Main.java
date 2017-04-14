package BackJun_1509;

import java.util.Scanner;

public class Main {
	static boolean[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String s = input.next();
		char[] temp = s.toCharArray();

		dp = new boolean[s.length()+1][s.length()+1];

		for(int i=1; i<=s.length()-1; i++){
			dp[i][i]=true;
			for(int j=1; j<i; j++){
				if(temp[i]==temp[j])
					dp[i][j]=dp[i-1][j+1];
				if(i==j-1){
					dp[i][j] |= temp[i]==temp[i+1];
				}
			}
		}

		for(int i=1; i<=s.length(); i++){
			for(int j=1; j<=s.length(); j++){
				if(dp[i][j]==true)
					System.out.print(1+ " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
	}

}
