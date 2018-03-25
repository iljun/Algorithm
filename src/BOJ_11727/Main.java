package BOJ_11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] dp;
    static final int DIVISION = 10007;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        if(N==1){
            System.out.println(1);
            return ;
        }
        dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 3;

        for(int i=3; i<N+1; i++){
            dp[i] = dp[i-1] + (2*dp[i-2]);
            dp[i] %=DIVISION;
        }

        System.out.println(dp[N]%DIVISION);
    }
}
