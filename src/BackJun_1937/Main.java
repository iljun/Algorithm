package BackJun_1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;
    static int[] col = {0, -1, 0 ,1};
    static int[] row = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        dp = new int[N][N];

        for(int i=0; i<N; i++){
            String[] inputLine = bf.readLine().split(" ");
            for(int j=0; j<inputLine.length; j++){
                arr[i][j] = Integer.parseInt(inputLine[j]);
            }
        }

        int max = 0;
        for(int i =0; i<N; i++){
            for(int j=0; j<N; j++){
                int count=dp(i,j);
                max = Math.max(max,count);
            }
        }

        System.out.println(max);
    }

    public static int dp(int startX, int startY){
        if(dp[startX][startY]>0)
            return dp[startX][startY];

        dp[startX][startY]=1;

        for(int i =0; i<4; i++){
            int x = startX + col[i];
            int y = startY + row[i];

            if(x<0 || x>=N || y<0 || y>=N)
                continue;
            if(arr[x][y] <= arr[startX][startY])
                continue;

            dp[startX][startY] = Math.max(dp[startX][startY],dp(x,y)+1);
        }

        return dp[startX][startY];
    }
}
