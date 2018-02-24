package BackKin_2399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String t = reader.readLine();
        arr= new long[Integer.parseInt(t)];

        String[] list = reader.readLine().split(" ");
        for(int i=0; i<list.length; i++)
            arr[i] = Integer.parseInt(list[i]);

        long sum =0 ;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++)
                sum+=Math.abs(arr[i]-arr[j]);
        }

        System.out.println(sum);
    }
}
