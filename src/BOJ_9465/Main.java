package BOJ_9465;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());
        while(T-->0){
            int n = Integer.parseInt(reader.readLine());
            int[][] arr = new int[2][n];
            String[] input;
            for(int i=0; i<2; i++){
                input = reader.readLine().split(" ");
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            writer.write(solve(arr,n)+"\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int[][] arr, int n){
        int[][] dp = new int[3][n];
        dp[0][0] = 0;
        dp[1][0] = arr[0][0];
        dp[2][0] = arr[1][0];

        for(int i=1; i<n; i++){
            dp[0][i]= Math.max(dp[0][i-1],Math.max(dp[1][i-1],dp[2][i-1]));
            dp[1][i]= Math.max(dp[0][i-1],dp[2][i-1]) + arr[0][i];
            dp[2][i]= Math.max(dp[0][i-1],dp[1][i-1]) + arr[1][i];
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<3; i++){
            max = Math.max(dp[i][n-1],max);
        }
        return String.valueOf(max);
    }
}
