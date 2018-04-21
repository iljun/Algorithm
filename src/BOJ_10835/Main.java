package BOJ_10835;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
         new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] left = new int[n];
        int[] right = new int[n];

        String[] input = reader.readLine().split(" ");
        for(int i=0; i<n; i++){
            left[i] = Integer.parseInt(input[i]);
        }

        input = reader.readLine().split(" ");
        for(int i=0; i<n; i++){
            right[i] = Integer.parseInt(input[i]);
        }

        dp = new int[n][n];
        for(int[] t : dp)
            Arrays.fill(t,-1);

        writer.write(String.valueOf(solve(n,left,right,0,0)));

        reader.close();
        writer.flush();
        writer.close();
    }

    static int[][] dp;
    public int solve(int n, int[] left, int[] right,int x,int y){
        if(x==n || y==n)
            return 0;

        if(dp[x][y]!=-1)
            return dp[x][y];

        int result = Math.max(solve(n,left,right,x+1,y),solve(n,left,right,x+1,y+1));//왼쪽을 버렸을때와 둘다버렸을때 최고값

        if(left[x] > right[y])
            result = Math.max(result,solve(n,left,right,x,y+1)+right[y]);// 오른쪽을 버릴때의 값 추가값
        dp[x][y] = result;
        return result;
    }
}
