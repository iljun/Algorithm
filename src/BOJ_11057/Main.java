package BOJ_11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] dp;
    static final int DIVISION = 10007;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        dp = new int[N+1][10];

        for(int i=0; i<10; i++)
            dp[0][i] = 1;

        for(int i=1; i<N+1; i++){
            dp[i][0] = dp[i-1][0];
            for(int j=1; j<10; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];

                dp[i][j]%=DIVISION;
            }
        }

        long result=0;
        for(int i=0; i<10; i++){
            result+=dp[N-1][i];
            result%=DIVISION;
        }

        System.out.println(result%DIVISION);
    }
}
