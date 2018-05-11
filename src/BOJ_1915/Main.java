package BOJ_1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            input = reader.readLine().split("");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                if(arr[i][j]==0)
                    continue;

                arr[i][j] += Math.min(arr[i][j-1],Math.min(arr[i-1][j-1],arr[i-1][j]));
            }
        }

        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                max = Math.max(max,arr[i][j]);
            }
        }

        System.out.println(max*max);
    }
}
