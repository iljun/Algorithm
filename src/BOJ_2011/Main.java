package BOJ_2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] dp = new long[5001];
    static final int DIVISION = 1000000;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        for(int i=1; i<String.valueOf(N).length(); i++){//수정
            int x = i - '0';
            if(0<x && x<10){
                dp[i] += dp[i-1];
                dp[i] %= DIVISION;
            }
            x = (i-'0')*10 + (i-'0');
            if(10<=x && x<27) {
                dp[i] += dp[i - 2];
                dp[i]%=DIVISION;
            }

        }

        System.out.println(dp[String.valueOf(N).length()]);
    }
}
