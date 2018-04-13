package BOJ_2098;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[][] arr = new int[n][n];

        String[] input;
        for(int i=0; i<n; i++){
            input = reader.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        writer.write(solve(arr,n));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int[][] arr, int n){
        for(int i=0; i<n; i++){
            boolean[] visited = new boolean[n];
            visited[i] = true;
            int j=i;

        }
        return "T";
    }

}
