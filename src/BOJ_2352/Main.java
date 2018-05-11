package BOJ_2352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] arr;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        arr = new long[N+1];
        dp = new long[N+1][N+1];

        String[] input = reader.readLine().split(" ");
        for(int i=1; i<N+1; i++){
            arr[i] = Long.parseLong(input[i-1]);
        }

        if(N==1){
            System.out.println(1);
            return ;
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){

                if(arr[i]>arr[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[N][N]);

    }

}
