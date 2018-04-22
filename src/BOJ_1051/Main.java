package BOJ_1051;

import java.io.*;
import java.util.Arrays;

public class Main {

    static int n;
    static int m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = reader.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                for (int k = 1; ; k++) {
                    if (i + k >= n || j + k >= m) {
                        break;
                    }

                    if(arr[i][j] == arr[i][j+k] && arr[i][j] == arr[i+k][j] && arr[i][j] == arr[i+k][j+k])
                        result = Math.max(result,(k+1)*(k+1));
                }
            }
        }

        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

}
