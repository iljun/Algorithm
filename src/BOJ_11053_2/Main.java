package BOJ_11053_2;

import java.io.*;
import java.util.Arrays;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 24
 * Time: 오후 1:57
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];
        String[] inputs = reader.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }

        writer.write(solve(n,arr));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int n, int[] arr){
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }

        int result = 0;
        for(int i=0; i<n; i++){
            result = Math.max(result,dp[i]);
        }

        return String.valueOf(result);
    }
}
