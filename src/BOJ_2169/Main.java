package BOJ_2169;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        int m;

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            input = reader.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        writer.write(solve(arr));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int[][] arr){

        return "내일";
    }
}
