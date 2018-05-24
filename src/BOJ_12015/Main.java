package BOJ_12015;

import java.io.*;
import java.util.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 24
 * Time: 오후 3:19
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n+1];
        String[] inputs = reader.readLine().split(" ");
        for (int i = 1; i < n+1; i++)
            arr[i] = Integer.parseInt(inputs[i-1]);

        writer.write(solve(n, arr));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int n, int[] arr) {
        int[] size = new int[n+1];
        size[1] = arr[1];
        int index = 1;

        for (int i = 2; i < n+1; i++) {
            if (size[index] < arr[i]) {
                size[++index]=arr[i];
            } else {
                size[lowerBound(size,arr[i],index)]=arr[i];
            }
        }
        int result = 0;
        for(int i=1; i<size.length;i++){
            if(size[i]==0)
                break;
            result++;
        }
        return String.valueOf(result);
    }

    private int lowerBound(int[] size, int k,int index) {
        int start = 0;
        int end = index+1;

        while (end - start > 0) {
            int middle = (start + end) / 2;
            if (size[middle] < k)
                start = middle + 1;
            else
                end = middle;
        }
        return end;
    }

}
