package BOJ_2169;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        new Main().input();
    }

    public void input(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        if(n==1 && m==1) {
            System.out.println(arr[0][0]);
            return ;
        }
        solve(arr,n,m);
    }

    public void solve(int[][] arr, int n, int m) {
        long[][] dp = new long[n][m];
        dp[0][0] = arr[0][0];

        if(n==1){
            long sum =0;
            for(int j=0 ; j<m; j++){
                sum+=arr[0][j];
            }
            System.out.println(sum);
            return ;
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }

        dp[1][0] = dp[0][0] + arr[1][0];

        for (int i = 1; i < n; i++) {
            long[] right = new long[m];
            long[] left = new long[m];

            left[0] = dp[i - 1][0] + arr[i][0];
            for (int j = 1; j < m; j++) {
                left[j] = Math.max(dp[i - 1][j], left[j - 1]) + arr[i][j];
            }

            right[m - 1] = dp[i - 1][m - 1] + arr[i][m - 1];
            for (int j = m - 2; j >= 0; j--) {
                right[j] = Math.max(dp[i - 1][j], right[j + 1]) + arr[i][j];
            }

            for(int j=0; j<m; j++){
                dp[i][j] = Math.max(left[j],right[j]);
            }
        }

//        return String.valueOf(dp[n - 1][m - 1]);
        System.out.println(dp[n-1][m-1]);
    }
}
