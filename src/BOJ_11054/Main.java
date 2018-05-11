package BOJ_11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static int[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        list = new int[N];
        String[] input = reader.readLine().split(" ");

        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(input[i]);
        }

        int[] lis = LIS(list);
        int[] lcs = LCS(list);

        int result = lis[0] + lcs[0];
        for(int i=1; i<list.length; i++){
            result = Math.max(result, lis[i]+lcs[i]);
        }

        System.out.println(result-1);
    }

    public static int[] LIS(int[] list){
        int[] dp = new int[list.length];

        for(int i=0; i<list.length; i++){
            if(dp[i]==0)
                dp[i]=1;
            for(int j=0; j<i; j++){
                if(list[i]>list[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        return dp;
    }

    public static int[] LCS(int[] list){
        int[] dp = new int[list.length];
        int size = list.length;

        for(int i=size-1; 0<=i; i--){
            if(dp[i]==0)
                dp[i]=1;
            for(int j=size-1; i<j; j--){
                if(list[i]>list[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        return dp;
    }
}
