package BackJun_2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] max = new int[3];
    static int[] min = new int[3];
    static int[] arr = new int[3];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        for(int i=0; i<N; i++){
            String[] tmp = reader.readLine().split(" ");
            arr[0] = Integer.parseInt(tmp[0]);
            arr[1] = Integer.parseInt(tmp[1]);
            arr[2] = Integer.parseInt(tmp[2]);

            int max0 = max[0];
            int max1 = max[1];
            int max2 = max[2];

            max[0] = Math.max(max0,max1) + arr[0];
            max[1] = Math.max(max0,Math.max(max1,max2)) + arr[1];
            max[2] = Math.max(max1,max2) + arr[2];

            int min0 = min[0];
            int min1 = min[1];
            int min2 = min[2];

            min[0] = Math.min(min0,min1) + arr[0];
            min[1] = Math.min(min0,Math.min(min1,min2)) + arr[1];
            min[2] = Math.min(min1,min2) + arr[2];
        }
        System.out.println(Math.max(max[0],Math.max(max[1],max[2])) + " " + Math.min(min[0],Math.min(min[1],min[2])));
    }
}
