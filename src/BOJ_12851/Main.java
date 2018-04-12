package BOJ_12851;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int K;
    static final int SIZE = 100001;
    static int[] arr = new int[SIZE];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        Arrays.fill(arr,-1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        arr[N] = 0;

        int cnt=0;
        while(!queue.isEmpty()){
            Integer currentPoint = queue.poll();

            if(currentPoint==K){
                cnt++;
            }

            if(currentPoint+1<SIZE){
                if(arr[currentPoint+1]==-1 || arr[currentPoint+1]==arr[currentPoint]+1){
                    arr[currentPoint+1] = arr[currentPoint]+1;
                    queue.offer(currentPoint+1);
                }
            }

            if(0<=currentPoint-1){
                if(arr[currentPoint-1]==-1 || arr[currentPoint-1] == arr[currentPoint]+1){
                    arr[currentPoint-1] = arr[currentPoint]+1;
                    queue.offer(currentPoint-1);
                }
            }

            if(currentPoint*2<SIZE){
                if(arr[currentPoint*2]==-1 || arr[currentPoint*2] == arr[currentPoint]+1){
                    arr[currentPoint*2] = arr[currentPoint]+1;
                    queue.offer(currentPoint*2);
                }
            }
        }
        writer.write(String.valueOf(arr[K])+"\n");
        writer.write(String.valueOf(cnt));

        reader.close();
        writer.flush();
        writer.close();
    }
}
