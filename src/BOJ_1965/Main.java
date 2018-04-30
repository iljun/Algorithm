package BOJ_1965;

import java.io.*;
import java.util.Arrays;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 28
 * Time: 오후 3:29
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n+1];
        String[] input = reader.readLine().split(" ");
        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(input[i-1]);
        }

        writer.write(String.valueOf(solve(n,arr)));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(int n, int[] arr){
        int[] dp = new int[n+1];

        for(int i=1; i<n+1; i++){
            dp[i] = 1;
            for(int j=1; j<=i; j++){
                if(arr[i]>arr[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }

        int result = 0;
        for(int i=1; i<n+1; i++)
            result = Math.max(result,dp[i]);

        return result;
    }
}
