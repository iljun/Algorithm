package BOJ_3190;

import java.io.*;

public class Main {
    static int N;
    static int K;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        K = Integer.parseInt(reader.readLine());
        arr = new int[N+1][N+1];

        String[] input;
        for(int i=0; i<K; i++){
            input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            arr[x][y] = 1;
        }


    }
}
