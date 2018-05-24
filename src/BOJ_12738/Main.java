package BOJ_12738;

import java.io.*;
import java.util.Arrays;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 24
 * Time: 오후 4:21
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        long[] arr = new long[n];
        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(inputs[i]);

        writer.write(solve(n, arr));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int n, long[] arr) {
        long[] dp = new long[n];
        dp[0] = arr[0];
        int index = 0;
        int result = 1;

        for (int i = 1; i < n; i++) {

            if(dp[index] < arr[i]) {
                dp[++index] = arr[i];
                result++;
            } else {
                dp[lowerBound(dp, arr[i], index)] = arr[i];
            }
        }

        return String.valueOf(result);
    }


    private int lowerBound(long[] list, long k, int index) {
        int start = 0;
        int end = index + 1;

        while (start < end) {
            int middle = (start + end) / 2;
            if (list[middle] < k)
                start = middle + 1;
            else
                end = middle;
        }
        return end;
    }
}
