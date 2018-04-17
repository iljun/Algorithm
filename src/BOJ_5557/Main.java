package BOJ_5557;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    static int[] arr;
    static long[][] dp = new long[101][21];
    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        arr = new int[n];

        String[] input = reader.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        dp[0][arr[0]]=1;
        writer.write(String.valueOf(solve(n-2,arr[n-1])));

        reader.close();
        writer.flush();
        writer.close();
    }

    public long solve(int n, int sum){
        if(sum<0 || sum>20)
            return 0;

        if(n == 0){
            return sum == arr[n] ? 1 : 0;
        }

        if(dp[n][sum] > 0)
            return dp[n][sum];

        dp[n][sum] = 0;
        dp[n][sum] += solve(n-1,sum+arr[n]);
        dp[n][sum] += solve(n-1,sum-arr[n]);

        return dp[n][sum];
    }

}
