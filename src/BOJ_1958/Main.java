package BOJ_1958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S1;
    static String S2;
    static String S3;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        S1 = reader.readLine();
        S2 = reader.readLine();
        S3 = reader.readLine();
        dp = new int[S1.length()+1][S2.length()+1][S3.length()+1];

        for(int i=1; i<S1.length()+1; i++){
            for(int j=1; j<S2.length()+1; j++){
                for(int k=1; k<S3.length()+1; k++){
                    if(S1.charAt(i-1)==S2.charAt(j-1) && S2.charAt(j-1)==S3.charAt(k-1)){
                        dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
                    }else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k],dp[i][j][k-1]));
                    }
                }
            }
        }

        System.out.println(dp[S1.length()][S2.length()][S3.length()]);
    }
}
